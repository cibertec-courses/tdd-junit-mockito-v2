package edu.pe.cibertec.advance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("ReservationServiceImpl - Unit Tests with Mockito")
public class ReservationServiceImplTest {
    // This one -> affects to DB
    // With Mock annotation we avoid interact and crash DB
    @Mock
    private ReservationRepository repository;

    // This one -> Real object to use in the testing.
    // With InjectMock annotation from the false repository automatically.
    @InjectMocks
    private ReservationServiceImpl service;

    ///  getAllReservations
    @Test
    @DisplayName("Returns all reservations from repository")
    void givenReservationsExist_whenGetAllReservations_thenReturnList() {
        // ARRANGE: We prepared a list of reservation in memory
        List<Reservation> reservations = List.of(
                new Reservation(1L, "Laura Torres", "101", "2026-04-01"),
                new Reservation(2L, "Rodrigo Palacios", "102", "2026-04-02")
        );

        // When findAll() is runs, mock returns our list.
        when(repository.findAll()).thenReturn(reservations);

        // ACT:
        List<Reservation> result = service.getAllReservations();

        // ASSERT: Check both results of reservations
        assertEquals(2, result.size());

        // Check findAll() method executed times.
        verify(repository, times(1)).findAll();
    }

    ///  getReservationById
    @Test
    @DisplayName("Returns reservation whe ID exists")
    void givenExistingId_whenGetReservationById_thenReturnReservation() {
        Reservation reservation = new Reservation(1L, "Pedro Paucar", "101", "2026-04-10");
        when(repository.findById(1L)).thenReturn(Optional.of(reservation));
        Reservation result = service.getReservation(1L);
        assertEquals("Pedro Paucar", result.getGuestName());
        verify(repository, times(1)).findById(1L);
    }

    ///  Throws exception when ID doesn't exist
    @Test

    @DisplayName("Throws exception when ID doesn't exist")
    void givenReservationId_whenNotExists_thenThrowException() {
        // ARRANGE
        Long id = 10L;
        when(repository.findById(id)).thenReturn(Optional.empty());
        assertThrows(ReservationNotFoundException.class, () -> service.getReservation(10L));
        verify(repository, times(1)).findById(id);

    }

    ///  registerReservation
    @Test
    @DisplayName("Registers reservation when room is available on that date")
    void givenAvailableRoom_whenRegisterReservation_thenReturnSavedReservation() {
        Reservation reservation =
                new Reservation(1L, "Laura Torres", "101", "2026-04-01");
        when(repository.finByRoomNumberAndCheckInDate("101", "2026-04-01"))
                .thenReturn(Optional.empty());
        when(repository.save(reservation)).thenReturn(reservation);
        Reservation result = service.registerReservation(reservation);
        assertEquals("Laura Torres", result.getGuestName());
        verify(repository, times(1)).save(reservation);
    }

    @Test
    @DisplayName("Throws exception when room is already reserved on that date")
    void givenOccupiedRoom_whenRegisterReservation_thenThrowsException() {
        Reservation reservation =
                new Reservation(1L, "Laura Torres", "101", "2026-04-01");
        when(repository.finByRoomNumberAndCheckInDate("101", "2026-04-01"))
                .thenReturn(Optional.of(reservation));
        assertThrows(IllegalArgumentException.class, () -> service.registerReservation(reservation));
        verify(repository, never()).save(any());
    }

    ///  deleteReservation
    @Test
    @DisplayName("Throws exception when delete reservation non-existing ID")
    void givenReservationDoesNotExist_whenDeleteReservation_thenThrowException(){
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(ReservationNotFoundException.class, () -> service.deleteReservation(1L));
        verify(repository, never()).deleteById(any());
    }

}


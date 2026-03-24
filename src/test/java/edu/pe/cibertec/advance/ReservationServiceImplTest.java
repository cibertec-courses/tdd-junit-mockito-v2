package edu.pe.cibertec.advance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

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
    void givenReservationsExist_whenGetAllReservations_thenReturnList(){
        // ARRANGE: We prepared a list of reservation in memory
        List<Reservation> reservations = List.of(
          new Reservation(1L, "Laura Torres", "101","2026-04-01"),
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


}

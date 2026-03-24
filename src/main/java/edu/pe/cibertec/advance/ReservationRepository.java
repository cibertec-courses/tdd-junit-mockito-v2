package edu.pe.cibertec.advance;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository {
    List<Reservation> findAll();
    Optional<Reservation> findById(Long id);
    Optional<Reservation> finByRoomNumberAndCheckInDate(String roomNumber, String checkInDate );
    Reservation save(Reservation reservation);
    void deleteById(Long Id);
}

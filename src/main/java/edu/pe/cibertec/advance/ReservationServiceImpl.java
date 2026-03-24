package edu.pe.cibertec.advance;

import java.util.List;

public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository repository;

    public ReservationServiceImpl(ReservationRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    @Override
    public Reservation getReservation(Long id) {
        return null;
    }

    @Override
    public Reservation registerReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {

    }
}

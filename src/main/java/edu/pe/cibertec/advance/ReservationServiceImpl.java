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
        return repository.findById(id)
                .orElseThrow( () -> new ReservationNotFoundException(id));
    }

    @Override
    public Reservation registerReservation(Reservation reservation) {
        if(repository.finByRoomNumberAndCheckInDate(
                reservation.getRoomNumber(),
                reservation.getCheckInDate()
        ).isPresent()){
            throw  new IllegalArgumentException(
                    "Room " + reservation.getRoomNumber()
                    + " is already reserver on "+ reservation.getCheckInDate()
            );
        }
        return repository.save(reservation);
    }

    @Override
    public void deleteReservation(Long id) {

    }


}

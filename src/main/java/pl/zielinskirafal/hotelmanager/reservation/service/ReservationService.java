package pl.zielinskirafal.hotelmanager.reservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zielinskirafal.hotelmanager.reservation.exception.ReservationNotFoundException;
import pl.zielinskirafal.hotelmanager.reservation.model.Reservation;
import pl.zielinskirafal.hotelmanager.reservation.repository.ReservationRepository;

import java.math.BigDecimal;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations(){
        return reservationRepository.findAll();
    }

    public Reservation addReservation(Reservation reservation){
        reservation.setDays(DAYS.between(reservation.getStartDate(), reservation.getEndDate()));
        reservation.setTotalCost(BigDecimal.valueOf(reservation.getDays()).multiply(reservation.getRoom().getCostPerNight()));
        return reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation){
        reservation.setDays(DAYS.between(reservation.getStartDate(), reservation.getEndDate()));
        reservation.setTotalCost(BigDecimal.valueOf(reservation.getDays()).multiply(reservation.getRoom().getCostPerNight()));
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

    public Reservation findReservationById(Long id){
        return reservationRepository.findById(id).orElseThrow(()->new ReservationNotFoundException("Reservation by id: "+id+" not found"));
    }

    public List<Reservation> findReservationByLastName(String lastName){
        return reservationRepository.findByCustomer_LastName(lastName).orElseThrow(()->new ReservationNotFoundException("Reservation by last name: "+lastName+" not found"));
    }

    //TODO: public List<Reservation> findReservationByDate()
}

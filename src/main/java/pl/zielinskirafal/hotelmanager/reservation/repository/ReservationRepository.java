package pl.zielinskirafal.hotelmanager.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zielinskirafal.hotelmanager.reservation.model.Reservation;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Optional<List<Reservation>> findByCustomer_LastName(String lastName);
}

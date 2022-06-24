package pl.zielinskirafal.hotelmanager.reservation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zielinskirafal.hotelmanager.reservation.model.Reservation;
import pl.zielinskirafal.hotelmanager.reservation.service.ReservationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping()
    public ResponseEntity<List<Reservation>> getAllReservations(){
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.getAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.findReservationById(id));
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<List<Reservation>> getReservationByName(@PathVariable("lastName") String lastName){
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.findReservationByLastName(lastName));
    }

    @PostMapping()
    public ResponseEntity<Reservation> addReservation(@RequestBody @Valid Reservation reservation){
        return ResponseEntity.status(HttpStatus.CREATED).body(reservationService.addReservation(reservation));
    }

    @PutMapping()
    public ResponseEntity<Reservation> updateReservation(@RequestBody @Valid Reservation reservation){
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.updateReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable("id") Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

package pl.zielinskirafal.hotelmanager.reservation.exception;

public class ReservationNotFoundException extends IllegalArgumentException {
    public ReservationNotFoundException(String message) {
        super(message);
    }
}

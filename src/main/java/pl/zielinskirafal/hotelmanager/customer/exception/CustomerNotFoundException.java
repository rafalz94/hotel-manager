package pl.zielinskirafal.hotelmanager.guest.exception;

public class customerNotFoundException extends RuntimeException {
    public customerNotFoundException(String message) {
        super(message);
    }
}

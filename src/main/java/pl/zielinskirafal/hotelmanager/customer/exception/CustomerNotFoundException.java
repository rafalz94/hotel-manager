package pl.zielinskirafal.hotelmanager.customer.exception;

public class CustomerNotFoundException extends IllegalArgumentException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}

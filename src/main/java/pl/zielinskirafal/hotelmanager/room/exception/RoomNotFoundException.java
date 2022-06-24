package pl.zielinskirafal.hotelmanager.room.exception;

public class RoomNotFoundException extends IllegalArgumentException {
    public RoomNotFoundException(String message) {
        super(message);
    }
}

package pl.zielinskirafal.hotelmanager.room.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zielinskirafal.hotelmanager.room.exception.RoomNotFoundException;
import pl.zielinskirafal.hotelmanager.room.model.Room;
import pl.zielinskirafal.hotelmanager.room.repository.RoomRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return new ArrayList<>(roomRepository.findAll());
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public Room updateRoom(Room room){
        return roomRepository.save(room);
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room findRoomByNumber(String number) {
        return roomRepository.findByNumber(number).orElseThrow(() -> new RoomNotFoundException("Room number: " + number + " not found"));
    }

    public List<Room> findRoomByBeds(int beds) {
        return roomRepository.findByBeds(beds).orElseThrow(()-> new RoomNotFoundException("Room of: "+beds+"not found"));
    }
}

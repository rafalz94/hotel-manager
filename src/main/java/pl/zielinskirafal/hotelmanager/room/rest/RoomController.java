package pl.zielinskirafal.hotelmanager.room.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zielinskirafal.hotelmanager.room.model.Room;
import pl.zielinskirafal.hotelmanager.room.service.RoomService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRooms());
    }

    @GetMapping("/{number}")
    public ResponseEntity<Room> getRoomByNumber(@PathVariable("number") String number){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.findRoomByNumber(number));
    }

    @GetMapping("/{beds}")
    public ResponseEntity<List<Room>> getRoomByBeds(@PathVariable("beds")int beds){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.findRoomByBeds(beds));
    }

    @PostMapping()
    public ResponseEntity<Room> addRoom(@RequestBody @Valid Room room){
        return ResponseEntity.status(HttpStatus.CREATED).body(roomService.addRoom(room));
    }

    @PutMapping()
    public ResponseEntity<Room> updateRoom(@RequestBody @Valid Room room){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.updateRoom(room));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable("id") Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

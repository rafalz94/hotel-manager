package pl.zielinskirafal.hotelmanager.room.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.zielinskirafal.hotelmanager.room.model.Room;
import pl.zielinskirafal.hotelmanager.room.service.RoomService;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping()
    public ResponseEntity<List<Room>> getAllRooms(){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getAllRooms());
    }

}

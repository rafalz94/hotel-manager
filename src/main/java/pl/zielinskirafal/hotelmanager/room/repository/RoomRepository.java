package pl.zielinskirafal.hotelmanager.room.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zielinskirafal.hotelmanager.room.model.Room;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

    Optional<Room> findByNumber(String number);

    Optional<List<Room>> findByBeds(int beds);
}

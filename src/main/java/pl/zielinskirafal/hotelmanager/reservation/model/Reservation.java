package pl.zielinskirafal.hotelmanager.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zielinskirafal.hotelmanager.customer.model.Customer;
import pl.zielinskirafal.hotelmanager.room.model.Room;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid = UUID.randomUUID();
    private LocalDate startDate;
    private LocalDate endDate;
    private Long days;
    //TODO: roomNumber -> auto generate room
    @ManyToOne
    private Room room;
    @ManyToOne
    //TODO: customerName -> auto generate customer
    private Customer customer;
    private BigDecimal totalCost;

}

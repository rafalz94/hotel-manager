package pl.zielinskirafal.hotelmanager.room.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pl.zielinskirafal.hotelmanager.reservation.model.Reservation;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Column(nullable = false)
    private int beds;

    @Column(nullable = false)
    private BigDecimal costPerNight;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

}

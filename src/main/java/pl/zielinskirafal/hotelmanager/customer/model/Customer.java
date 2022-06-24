package pl.zielinskirafal.hotelmanager.customer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import pl.zielinskirafal.hotelmanager.reservation.model.Reservation;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    private Reservation reservation;

}

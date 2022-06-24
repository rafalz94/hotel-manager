package pl.zielinskirafal.hotelmanager.guest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zielinskirafal.hotelmanager.guest.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    void deleteCustomerById(Long id);

    Optional<List<Customer>> findCustomerByLastName(String lastName);

}

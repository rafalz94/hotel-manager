package pl.zielinskirafal.hotelmanager.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zielinskirafal.hotelmanager.customer.model.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<List<Customer>> findCustomerByLastName(String lastName);

}

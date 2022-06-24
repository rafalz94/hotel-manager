package pl.zielinskirafal.hotelmanager.guest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zielinskirafal.hotelmanager.guest.exception.customerNotFoundException;
import pl.zielinskirafal.hotelmanager.guest.model.Customer;
import pl.zielinskirafal.hotelmanager.guest.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteCustomerById(id);
    }

    public List<Customer> findCustomer(String lastName) {
        return customerRepository.findCustomerByLastName(lastName).orElseThrow(() -> new customerNotFoundException("Customer by last name: " + lastName + " not found"));
    }
}

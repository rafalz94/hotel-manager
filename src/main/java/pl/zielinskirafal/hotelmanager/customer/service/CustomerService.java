package pl.zielinskirafal.hotelmanager.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zielinskirafal.hotelmanager.customer.exception.CustomerNotFoundException;
import pl.zielinskirafal.hotelmanager.customer.model.Customer;
import pl.zielinskirafal.hotelmanager.customer.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public List<Customer> findCustomer(String lastName) {
        return customerRepository.findCustomerByLastName(lastName).orElseThrow(() -> new CustomerNotFoundException("Customer by last name: " + lastName + " not found"));
    }
}

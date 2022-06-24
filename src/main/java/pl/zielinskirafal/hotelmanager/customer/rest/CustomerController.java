package pl.zielinskirafal.hotelmanager.customer.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zielinskirafal.hotelmanager.customer.model.Customer;
import pl.zielinskirafal.hotelmanager.customer.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
    }

    @GetMapping("/{lastName}")
    public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable("lastName") String lastName){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findCustomer(lastName));
    }

    @PostMapping()
    public ResponseEntity<Customer> addCustomer(@RequestBody @Valid Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customer));
    }

    @PutMapping()
    public ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.updateCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

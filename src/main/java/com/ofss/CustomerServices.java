package com.ofss;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class CustomerServices {
    @Autowired
    private CustomerRepository customerRepository;
    // POST
    public ResponseEntity<Object> addCustomer(Customer newCustomer) {
        return ResponseEntity.status(201).body(customerRepository.save(newCustomer));
    }
    // GET all
    public Iterable<Customer> fetchAllCustomers() {
        return customerRepository.findAll();
    }
    // GET by ID
    public ResponseEntity<Customer> getCustomerById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }
    // DELETE by ID
    public ResponseEntity<String> deleteCustomerById(int id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("Customer deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
    
    
    
 // PUT – Full update (replace all fields except ID)
    public ResponseEntity<Object> updateCustomer(int id, Customer updatedCustomer) {
        Optional<Customer> existingOpt = customerRepository.findById(id);

        if (existingOpt.isPresent()) {
            Customer existing = existingOpt.get();

            // Update all fields except custId
            existing.setFirstName(updatedCustomer.getFirstName());
            existing.setLastName(updatedCustomer.getLastName());
            existing.setPhoneNumber(updatedCustomer.getPhoneNumber());
            existing.setCity(updatedCustomer.getCity());
            existing.setEmailId(updatedCustomer.getEmailId());

            Customer savedCustomer = customerRepository.save(existing);
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.status(404).body("Customer with ID " + id + " not found");
        }
    }


 // PATCH – Partial update (only non-null fields, except ID)
    public ResponseEntity<Object> partiallyUpdateCustomer(int id, Customer partialCustomer) {
        Optional<Customer> existingOpt = customerRepository.findById(id);

        if (existingOpt.isPresent()) {
            Customer existing = existingOpt.get();

            // Only update non-null fields (and valid values where necessary)
            if (partialCustomer.getFirstName() != null)
                existing.setFirstName(partialCustomer.getFirstName());

            if (partialCustomer.getLastName() != null)
                existing.setLastName(partialCustomer.getLastName());

            if (partialCustomer.getPhoneNumber() != null)
                existing.setPhoneNumber(partialCustomer.getPhoneNumber());

            if (partialCustomer.getCity() != null)
                existing.setCity(partialCustomer.getCity());

            if (partialCustomer.getEmailId() != null)
                existing.setEmailId(partialCustomer.getEmailId());

            Customer updatedCustomer = customerRepository.save(existing);
            return ResponseEntity.ok(updatedCustomer);
        } else {
            return ResponseEntity.status(404).body("Customer with ID " + id + " not found");
        }
    }


}
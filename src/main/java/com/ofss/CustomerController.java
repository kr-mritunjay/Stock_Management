package com.ofss;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class CustomerController {
    @Autowired
    private CustomerServices customerService;
    @Autowired
    private CustomerRepository customerRepository;
    // POST – Add a new customer
    @RequestMapping(value="/customers", method=RequestMethod.POST)
    public ResponseEntity<Object> addCustomer(@RequestBody Customer newCustomer) {
        return customerService.addCustomer(newCustomer);
    }
    // GET – Fetch all customers
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> fetchAll() {
        List<Customer> allCustomers = (List<Customer>) customerRepository.findAll();
        return ResponseEntity.ok(allCustomers);
    }
    // GET – Fetch a single customer by ID
    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }
    // DELETE – Remove a customer by ID
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable int id) {
        return customerService.deleteCustomerById(id);
    }
    
    
 // PUT – Full update (except customer ID)
    @PutMapping("/customers/{id}")
    public ResponseEntity<Object> updateCustomer(
            @PathVariable int id,
            @RequestBody Customer updatedCustomer) {
        return customerService.updateCustomer(id, updatedCustomer);
    }

    // PATCH – Partial update (only non-null fields, ID not changeable)
    @PatchMapping("/customers/{id}")
    public ResponseEntity<Object> partiallyUpdateCustomer(
            @PathVariable int id,
            @RequestBody Customer partialCustomer) {
        return customerService.partiallyUpdateCustomer(id, partialCustomer);
    }

}


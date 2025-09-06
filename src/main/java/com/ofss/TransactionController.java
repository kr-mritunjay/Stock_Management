package com.ofss;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
public class TransactionController {
    @Autowired
    private TransactionServices transactionService;
    @Autowired
    private TransactionRepository transactionRepository;
    // POST – Add a new transaction
    @RequestMapping(value="/transactions", method=RequestMethod.POST)
    public ResponseEntity<Object> addTransaction(@RequestBody Transaction newTransaction) {
        return transactionService.addTransaction(newTransaction);
    }
    // GET – Fetch all transactions
    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> fetchAll() {
        List<Transaction> allTransactions = (List<Transaction>) transactionRepository.findAll();
        return ResponseEntity.ok(allTransactions);
    }
    // GET – Fetch a single transaction by ID
    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable int id) {
        return transactionService.getTransactionById(id);
    }
    // DELETE – Remove a transaction by ID
    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<String> deleteTransactionById(@PathVariable int id) {
        return transactionService.deleteTransactionById(id);
    }
    
 // PUT – Full update (except ID)
    @PutMapping("/transactions/{id}")
    public ResponseEntity<Object> updateTransaction(
            @PathVariable int id,
            @RequestBody Transaction updatedTransaction) {
        return transactionService.updateTransaction(id, updatedTransaction);
    }

    // PATCH – Partial update (only non-null fields, ID cannot be changed)
    @PatchMapping("/transactions/{id}")
    public ResponseEntity<Object> partiallyUpdateTransaction(
            @PathVariable int id,
            @RequestBody Transaction partialTransaction) {
        return transactionService.partiallyUpdateTransaction(id, partialTransaction);
    }

}
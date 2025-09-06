package com.ofss;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransactionServices {

    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<Object> addTransaction(Transaction newTransaction) {
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionRepository.save(newTransaction));
    }

    public ResponseEntity<Transaction> getTransactionById(int id) {
        Optional<Transaction> txn = transactionRepository.findById(id);
        return txn.map(ResponseEntity::ok)
                  .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    public ResponseEntity<String> deleteTransactionById(int id) {
        Optional<Transaction> txn = transactionRepository.findById(id);
        if (txn.isPresent()) {
            transactionRepository.deleteById(id);
            return ResponseEntity.ok("Transaction with ID " + id + " deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Transaction with ID " + id + " not found");
        }
    }

    // ✅ PUT – Full update (ID not updatable)
    public ResponseEntity<Object> updateTransaction(int id, Transaction updatedTxn) {
        Optional<Transaction> existingOpt = transactionRepository.findById(id);
        if (existingOpt.isPresent()) {
            Transaction existing = existingOpt.get();

            // Update all fields except txnId
            existing.setCustomer(updatedTxn.getCustomer());
            existing.setStock(updatedTxn.getStock());
            existing.setTxnPrice(updatedTxn.getTxnPrice());
            existing.setTxnType(updatedTxn.getTxnType());
            existing.setQty(updatedTxn.getQty());
            existing.setTxnDate(updatedTxn.getTxnDate());

            return ResponseEntity.ok(transactionRepository.save(existing));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Transaction with ID " + id + " not found");
        }
    }

    // ✅ PATCH – Partial update (only non-null fields)
    public ResponseEntity<Object> partiallyUpdateTransaction(int id, Transaction partialTxn) {
        Optional<Transaction> existingOpt = transactionRepository.findById(id);
        if (existingOpt.isPresent()) {
            Transaction existing = existingOpt.get();

            // Null checks before updating fields
            if (partialTxn.getCustomer() != null)
                existing.setCustomer(partialTxn.getCustomer());

            if (partialTxn.getStock() != null)
                existing.setStock(partialTxn.getStock());

            if (partialTxn.getTxnPrice() != null)
                existing.setTxnPrice(partialTxn.getTxnPrice());

            if (partialTxn.getTxnType() != null)
                existing.setTxnType(partialTxn.getTxnType());

            if (partialTxn.getQty() != null)
                existing.setQty(partialTxn.getQty());

            if (partialTxn.getTxnDate() != null)
                existing.setTxnDate(partialTxn.getTxnDate());

            return ResponseEntity.ok(transactionRepository.save(existing));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .body("Transaction with ID " + id + " not found");
        }
    }
}

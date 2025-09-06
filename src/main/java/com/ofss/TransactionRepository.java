package com.ofss;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer>{
	// no need to write anything here
}
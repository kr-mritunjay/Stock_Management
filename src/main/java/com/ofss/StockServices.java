package com.ofss;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class StockServices {
	@Autowired
	StockRepository stockRepository;
	
	
	
	// adding new stocks
	public ResponseEntity<Object> addAStock(Stock newStock) {
		// save() method generates INSERT INTO query
		return ResponseEntity.status(201).body(stockRepository.save(newStock));
	}
	
	
	// getting all stocks
	
	public ResponseEntity<Object> fetchAllStocks()
	{
		return ResponseEntity.status(201).body(stockRepository.findAll());
	}
	
	public ResponseEntity<Object> fetchStockById(int sid)
	{
		Optional<Stock> stock=stockRepository.findById(sid);
		
		 if (stock.isPresent()) {
		        return ResponseEntity.ok(stock.get());
		    } else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                             .body("Stock with ID " + sid + " not found");
		    }
		
		
	}
	
	// deleting a stock
	
	public ResponseEntity<Object> deleteStockById(int sid)
	{
		Optional<Stock> stock=stockRepository.findById(sid);
		if(stock.isPresent())
		{
			stockRepository.deleteById(sid);
	        return ResponseEntity.ok(stock.get()+" deleted");
		}
		 else {
		        return ResponseEntity.status(HttpStatus.NOT_FOUND)
		                             .body("Stock with ID " + sid + " not found");
		    }
	}
	
	public ResponseEntity<Object> updateStockById(int sid, Stock updatedStock) {
	    Optional<Stock> existingStockOpt = stockRepository.findById(sid);

	    if (existingStockOpt.isPresent()) {
	        Stock existingStock = existingStockOpt.get();

	        // Only update non-ID fields
	        existingStock.setStockName(updatedStock.getStockName());
	        existingStock.setStockPrice(updatedStock.getStockPrice());
	        existingStock.setStockVolume(updatedStock.getStockVolume());
	        existingStock.setListedExchange(updatedStock.getListedExchange());
	        existingStock.setListingPrice(updatedStock.getListingPrice());
	        existingStock.setListedDate(updatedStock.getListedDate());

	        // Save the updated entity
	        Stock savedStock = stockRepository.save(existingStock);
	        return ResponseEntity.ok(savedStock);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Stock with ID " + sid + " not found");
	    }
	}


	public ResponseEntity<Object> partiallyUpdateStockById(int sid, Stock partialStock) {
	    Optional<Stock> existingStockOpt = stockRepository.findById(sid);

	    if (existingStockOpt.isPresent()) {
	        Stock existingStock = existingStockOpt.get();

	        // Update only non-null fields
	        if (partialStock.getStockName() != null)
	            existingStock.setStockName(partialStock.getStockName());

	        if (partialStock.getStockPrice() != 0.0)  // Avoid overwriting with 0.0 unless valid
	            existingStock.setStockPrice(partialStock.getStockPrice());

	        // Save the updated stock
	        Stock updatedStock = stockRepository.save(existingStock);
	        return ResponseEntity.ok(updatedStock);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Stock with ID " + sid + " not found");
	    }
	}

}
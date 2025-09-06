package com.ofss;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TRANSACTIONS")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "txn_seq", sequenceName = "TXN_SEQ", allocationSize = 1)
    @Column(name = "TXN_ID")
    private Integer txnId;

    @ManyToOne
    @JoinColumn(name = "CUST_ID", referencedColumnName = "CUST_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "STOCK_ID", referencedColumnName = "STOCK_ID")
    private Stock stock;

    @Column(name = "TXN_PRICE")
    private Double txnPrice;

    @Column(name = "TXN_TYPE")
    private String txnType;

    @Column(name = "QTY")
    private Long qty;

    @Column(name = "TXN_DATE")
    @Temporal(TemporalType.DATE)
    private Date txnDate;

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer txnId, Customer customer, Stock stock, Double txnPrice, String txnType, Long qty,
			Date txnDate) {
		super();
		this.txnId = txnId;
		this.customer = customer;
		this.stock = stock;
		this.txnPrice = txnPrice;
		this.txnType = txnType;
		this.qty = qty;
		this.txnDate = txnDate;
	}

	public Integer getTxnId() {
		return txnId;
	}

	public void setTxnId(Integer txnId) {
		this.txnId = txnId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Double getTxnPrice() {
		return txnPrice;
	}

	public void setTxnPrice(Double txnPrice) {
		this.txnPrice = txnPrice;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Date getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(Date txnDate) {
		this.txnDate = txnDate;
	}

    // Getters and Setters
    
    
}


# 📈 StocksManager_2025

## Overview
**StocksManager_2025** is a robust Java-based application designed to efficiently manage stock inventories and customer data through a simplified interface. It supports core functionalities like adding, updating, and removing stocks, managing customer information, and facilitating transactions such as stock purchases and sales.  

The system is built with scalability and maintainability in mind, integrating seamlessly with an **Oracle database** to ensure persistent and reliable data storage.

---

## 🚀 Key Features

### 🔹 Stock Management
- **Add New Stock**: Create new stock entries by providing details like stock name, symbol, price, and quantity.  
- **Remove Stock**: Delete stock entries using their unique symbol.  
- **Update Stock**: Modify existing stock records, including stock price and available quantity.  
- **Retrieve Stock**: Fetch stock details from the database.  

### 🔹 Customer Management
- **Add New Customer**: Register new customers with details such as name, customer ID, and email address.  
- **Remove Customer**: Delete customer profiles using their unique customer ID.  
- **Update Customer**: Modify existing customer details.  
- **Retrieve Customer**: Fetch customer records from the database.  

### 🔹 Stock Transactions
- **Purchase Stocks**: Customers can buy stocks. The system updates inventory and logs the purchase in the customer’s history.  
- **Sell Stocks**: Customers can sell previously purchased stocks. The system updates inventory and records the sale in the customer’s history.  

---

## 🗄️ Data Persistence
The application uses **Oracle Database (v23)** for storing:
- Stock details  
- Customer information  
- Transaction records  

This ensures data is consistent, reliable, and persists across sessions.

---

## 🛠️ Technologies Used
- **Programming Language**: Java 21  
- **Framework**: Spring Boot 5 (Java EE 7 Platform)  
- **Server**: Apache Tomcat 10  
- **Database**: Oracle 23  
- **Architecture**: Object-Oriented Design  

---

## 📌 Project Architecture

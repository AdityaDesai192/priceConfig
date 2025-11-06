# PriceConfig

PriceConfig is a simple Java console application built using JDBC and MySQL.  
It allows users to add and view product pricing details from a connected database.  
The project demonstrates core Java programming skills along with database connectivity and CRUD operations.

---

##  Features

- Add product name and price to database  
- Retrieve and display all products with their details  
- Interactive console-based interface  
- MySQL integration using JDBC  
- Clean modular structure with DAO and utility classes

---

##  Tech Stack

- **Language:** Java  
- **Database:** MySQL  
- **Connector:** MySQL JDBC Driver  
- **IDE Used:** VS Code  
- **Version Control:** Git & GitHub


---

## ⚙️ Setup Instructions

1. **Create Database**
   ```sql
   CREATE DATABASE price_db;
   USE price_db;
   CREATE TABLE products (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(50),
       price DOUBLE
   );


Update Credentials

Open DBConnection.java

Replace:

private static final String USER = "enter your username";
private static final String PASSWORD = "enter your password";

----

Run the App

javac -cp ".;lib/mysql-connector-j-9.5.0.jar;src" src/*.java

java -cp ".;lib/mysql-connector-j-9.5.0.jar;src" PriceConfigApp



------

Sample Output:

1. Add Product
2. View Products
3. Exit
Choose: 1
Enter product name: Keyboard
Enter price: 750
 Product added!

Choose: 2
ID: 1, Name: Keyboard, Price: ₹750.0



# Merchant Product Management System (JPA / Hibernate One-to-Many Bi-Directional)

A console-based Java application demonstrating a **One-to-Many Bi-directional** mapping between `Merchant` and `Product` entities using **JPA (Java Persistence API)** and **Hibernate ORM** with the Data Access Object (DAO) pattern.

---

## 📌 Project Overview

This project models a relational domain where:
* **`Merchant` (Parent / One-to-Many):** A merchant can be associated with multiple products (`@OneToMany(mappedBy = "m")`).
* **`Product` (Child / Many-to-One):** Each product is associated with a single merchant (`@ManyToOne` with `@JoinColumn`).

The system provides a command-line menu driven controller enabling full CRUD operations and specialized search functions for both entities.

---

## 🛠️ Tech Stack

* **Language:** Java
* **ORM Framework:** JPA 2.0+ / Hibernate
* **Database Access:** `EntityManager`, `EntityTransaction`, `TypedQuery` (JPQL)
* **Architecture:** MVC / DAO Architecture (`dto`, `dao`, `controller`)

---

## 📂 Repository File Structure

```
src/
└── org/jsp/merchant_product/
    ├── dto/
    │   ├── Merchant.java                      # Parent Entity (Merchant details & @OneToMany mapping)
    │   └── Product.java                       # Child Entity (Product details & @ManyToOne mapping)
    │
    ├── dao/
    │   ├── MerchantDao.java                   # DAO handling Merchant persistence operations
    │   └── ProductDao.java                    # DAO handling Product persistence operations
    │
    └── controller/
        └── Merchant_Product_Controller.java   # Interactive CLI application controller
```

---

## ⚙️ Database Schema & Mapping

### `Merchant` Entity
* **`id`** (`int`): Primary key (`GenerationType.IDENTITY`).
* **`name`** (`String`): Merchant's full name.
* **`gst_num`** (`String`): Unique GST Identification Number (`@Column(unique = true)`).
* **`email`** (`String`): Unique email address (`@Column(unique = true)`).
* **`phone`** (`long`): Unique contact phone number (`@Column(unique = true)`).
* **`password`** (`String`): Account authentication password.
* **`prods`** (`List<Product>`): List of products associated with the merchant (`mappedBy = "m"`, `CascadeType.ALL`).

### `Product` Entity
* **`id`** (`int`): Primary key (`GenerationType.IDENTITY`).
* **`name`** (`String`): Name of the product.
* **`brand`** (`String`): Brand or manufacturer.
* **`category`** (`String`): Category or classification.
* **`price`** (`double`): Product unit price.
* **`m`** (`Merchant`): Owning side foreign key reference back to `Merchant` (`@ManyToOne`, `@JoinColumn`).

---

## 📋 Features & Menu Options

The application presents an interactive menu in `Merchant_Product_Controller.java` with 11 core options:

| Option | Operation | Target Entity / Method | Description |
| :--- | :--- | :--- | :--- |
| **1** | Save Merchant | `MerchantDao.saveMerchant()` | Registers a new merchant record. |
| **2** | Update Merchant | `MerchantDao.updateMerchant()` | Updates details (phone, email, password, etc.) for an existing merchant. |
| **3** | Find Merchant By ID | `MerchantDao.findMerchantById()` | Fetches merchant details by primary key ID. |
| **4** | Find Merchant By Name & Password | `MerchantDao.findMerchantByNameAndPassword()` | Authenticates and retrieves merchant details via JPQL query. |
| **5** | Find Merchant By Product ID | `MerchantDao.findMerchantByProductId()` | Performs a join-query to locate the owning merchant of a given product. |
| **6** | Add Product | `ProductDao.addProduct()` | Assigns and persists a new product under a specific merchant ID. |
| **7** | Update Product | `ProductDao.updateProduct()` | Modifies name, brand, category, or price of an existing product. |
| **8** | Find All Products | `ProductDao.findAllProduct()` | Fetches and displays all product entries in the system. |
| **9** | Find Product By Merchant Name | `ProductDao.findProductBuMerchantName()` | Queries all products owned by merchants with a given name. |
| **10** | Find Product By GST & Password | `ProductDao.findProductByMerchantGstNumAndPassword()` | Authenticates via merchant credentials to list associated products. |
| **11** | Exit | `System.exit(0)` | Terminates the application. |

---

## 🚀 How to Run

1. **Database Setup:**
   Ensure your database is configured and update your `src/META-INF/persistence.xml` with the matching persistence unit name (`"M15"`), database URL, username, and password.

2. **Compile and Run:**
   Run `Merchant_Product_Controller.java` directly from your Java IDE or terminal.

3. **Usage:**
   Follow the CLI menu prompts to interact with the database.

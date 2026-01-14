# 🏦 QuickLoan - Microservices Banking System

A distributed banking application built with **Spring Boot Microservices** handling user identity, loan processing, and wallet disbursements.

## 🚀 Architecture
The system consists of the following microservices:

1.  **Discovery Server (Eureka):** Service Registry (Port `8761`).
2.  **API Gateway:** Entry point for all traffic (Port `8080`).
3.  **Identity Service:** User registration and authentication (Port `8081`).
4.  **Loan Service:** Core logic for applying and approving loans (Port `8082`).
5.  **Wallet Service:** Manages user balances and transactions (Port `8083`).

## 🛠️ Tech Stack
* **Java 21**
* **Spring Boot 3.2**
* **Spring Cloud** (Eureka, Gateway, OpenFeign, Resilience4j)
* **PostgreSQL** (Database per service)
* **Gradle** (Build Tool)

## ⚙️ Setup & Running

### 1. Prerequisites
* Java 21 Installed
* PostgreSQL Installed & Running

### 2. Database Setup
Create the following databases in PostgreSQL:
```sql
CREATE DATABASE identity_db;
CREATE DATABASE loan_db;
CREATE DATABASE wallet_db;

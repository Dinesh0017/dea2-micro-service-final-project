# 🚀 Microservices Warehouse Management System

A full-scale **Enterprise Warehouse Management System** built using **Microservices Architecture** as part of the Enterprise Application II module.

This system demonstrates real-world distributed system design using modern backend technologies and cloud deployment.

---

## 📌 Overview

This system is designed to manage warehouse operations efficiently using a **microservices-based architecture**.

Key functionalities include:
- Inventory tracking  
- Order management  
- Supplier & customer handling  
- Dispatch and logistics  
- Workforce and equipment management  

Each module is developed as an independent microservice and integrated into a single distributed system.

---

## 🧩 System Architecture

The system follows a **Microservices Architecture**, where:

- Each service is independently developed and deployed  
- Services communicate via REST APIs  
- Service discovery is handled using Eureka  
- API Gateway routes requests to services  
- Each service manages its own database  

---

## 🔧 Technologies Used

### Backend
- Spring Boot  
- Spring Data JPA  
- REST APIs  
- Java  

### Database
- PostgreSQL  

### Architecture & Tools
- Microservices Architecture  
- Eureka Server (Service Discovery)  
- Swagger (API Documentation)  

### Deployment
- AWS EC2  

### Frontend
- Next.js  

### Version Control
- Git & GitHub  

---

## ⚙️ System Services

The system consists of multiple microservices:

- Customer Management Service  
- Supplier Management Service  
- Product Catalog Service  
- Inbound Receiving Service  
- Inventory Management Service  
- Order Management Service  
- Picking & Packing Service  
- Dispatch & Transportation Service  
- Workforce & Equipment Service  
- Storage Location Service  

---

## 🔄 System Workflow

1. Supplier sends products to warehouse  
2. Inbound Receiving Service records incoming shipments  
3. Inventory Service updates stock levels  
4. Order Management processes orders  
5. Picking & Packing prepares items  
6. Dispatch Service handles delivery  
7. Workforce Service manages staff and equipment  

---

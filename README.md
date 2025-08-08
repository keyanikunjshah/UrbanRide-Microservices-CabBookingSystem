# 🚖 UrbanRide – Microservices Cab Booking System

A full-stack cab booking system built using a **Spring Boot Microservices architecture**. Features real-time driver matching, user management, booking flow, service discovery, and containerization with Docker.

---

## 🧩 Project Architecture

This system is composed of the following services:

- **API Gateway**: Central entry point to route requests to microservices
- **Eureka Service**: Service registry using Netflix Eureka
- **User Service**: Handles user registration and authentication
- **Cab Service**: Manages cab availability and driver data
- **Booking Service**: Manages booking logic and trip flow
- **Frontend**: Simple UI built with HTML/CSS/JS
- **Docker Compose**: To spin up all services together

---

## 🔧 Tech Stack

| Layer            | Tools / Technologies                             |
|------------------|--------------------------------------------------|
| Backend          | Java, Spring Boot, REST APIs, Microservices      |
| Frontend         | HTML, CSS, JavaScript                            |
| Database         | In-memory or MySQL (if added)                    |
| Auth / Realtime  | Firebase (optional for frontend), WebSockets     |
| DevOps           | Docker, Docker Compose, Git                      |
| Service Discovery| Netflix Eureka                                   |

---

## 📦 Folder Structure

CabBookingSystem/
├── api-gateway/
├── user-service/
├── cab-service/
├── booking-service/
├── eureka-service/
├── Cab-booking front end/
├── docker-compose/


---

## ⚙️ How to Run

1. **Clone the repository**
   ```bash
   git clone git@github.com:keyanikunjshah/UrbanRide-Microservices-CabBookingSystem.git
   cd UrbanRide-Microservices-CabBookingSystem


   

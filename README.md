# NxtGen-AI-eWallet-Application

Welcome to the **NxtGen-AI-eWallet-Application**! This innovative digital wallet solution is designed to simplify transactions, enhance user experience, and provide a secure environment for managing finances with AI.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
- [How to Access](#how-to-access)
- [Why NxtGen-AI-eWallet?](#why-nxtgen-ai-ewallet)
- [Contributing](#contributing)
- [License](#license)

## Project Structure

```
NxtGen-AI-eWallet-Application
├── .idea/
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── Dockerfile
├── docker-compose.yml
├── Jenkinsfile
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.dkcodie.ewallet
│   │   │       ├── config
│   │   │       │   └── SpringSecurityConfig.java
│   │   │       ├── controller
│   │   │       │   ├── AuthController.java
│   │   │       │   ├── PdfController.java
│   │   │       │   ├── TransactionController.java
│   │   │       │   └── WalletController.java
│   │   │       ├── dto
│   │   │       │   ├── TransactionDto.java
│   │   │       │   ├── UserDetailsDto.java
│   │   │       │   └── UserDto.java
│   │   │       ├── entity
│   │   │       │   ├── Role.java
│   │   │       │   ├── Transaction.java
│   │   │       │   └── User.java
│   │   │       ├── exception
│   │   │       │   └── GlobalExceptionHandler.java
│   │   │       ├── repository
│   │   │       │   ├── RoleRepository.java
│   │   │       │   ├── TransactionRepository.java
│   │   │       │   └── UserRepository.java
│   │   │       ├── security
│   │   │       │   └── CustomUserDetailsService.java
│   │   │       ├── service
│   │   │       │   ├── PdfService.java
│   │   │       │   ├── TransactionService.java
│   │   │       │   ├── TransactionServiceImpl.java
│   │   │       │   ├── UserService.java
│   │   │       │   └── UserServiceImpl.java
│   │   │       └── EwalletApplication.java
│   │   └── resources
│   │       ├── static
│   │       │   ├── css
│   │       │   │   ├── dashboard.css
│   │       │   │   └── styles.css
│   │       ├── templates
│   │       │   ├── dashboard.html
│   │       │   ├── index.html
│   │       │   ├── login.html
│   │       │   ├── register.html
│   │       │   ├── transactions.html
│   │       │   ├── Transfer.html
│   │       │   └── users.html
│   │       ├── application.properties
│   │       └── wallet.mv.db
│   └── test
│       └── java
│           └── com.dkcodie.ewallet
│               └── RegistrationLoginApplicationTests.java
└── target/

```

## Features

- **User Registration and Login:** Simple registration process with email verification.
- **Transaction Management:** Easily create, view, and manage transactions.
- **Peer-to-Peer Transactions:** Send and receive money from other users seamlessly.
- **User Dashboard:** A comprehensive dashboard displaying user details, transaction history, and wallet balance.
- **Admin Interface:** Manage users and monitor transactions efficiently.
- **PDF Generation:** Export transaction history as a PDF for records.


## API Endpoints
- `GET /api/users` - Get all users
- `GET /api/users/{id}` - Get user details
- `GET /api/transactions/{userId}` - Get transactions for a user
- `POST /api/transactions` - Create a new transaction

  
## Technologies Used

- **Backend:** Java, Spring Boot
- **Frontend:** JavaScript, Html, Css, Thymeleaf
- **Database:** H2 Database(integrated)
- **Containerization:** Docker
- **Version Control:** Git, GitHub, Jenkins

## Getting Started

### Prerequisites

- Java 21
- Maven
- Docker (optional, for containerization)
- Node.js (if required for frontend development)

### Clone the Repository

To clone the repository, use the following command:

git clone https://github.com/dkcodie/NxtGen-AI-eWallet.git


### Build & run the application

mvn clean install
mvn spring-boot:run


### Docker, build and run with:

docker-compose up --build





### Notes:
- You can customize any sections further based on specific features or details you want to highlight.
- Ensure the formatting is preserved when you copy this into your README.md file.


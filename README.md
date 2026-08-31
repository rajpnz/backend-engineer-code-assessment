# Backend Engineer Code Assessment 
## Savings Account API

A Spring Boot REST API for creating and retrieving savings bank accounts.

## Tech Stack

- **Java 21**
- **Spring Boot 4.1.1** (Spring Web, Spring Data JPA, Spring Validation)
- **Maven** — build tool
- **PostgreSql** — database

## Features

- Create a new savings bank account
- Retrieve a savings bank account by account number
- Request body validation
- Business rule enforcement (nickname length, offensive nickname check)

## API Endpoints

### Create Account

```
POST /api/v1/savings-accounts
Content-Type: application/json

{
  "customerName": "Jane Doe",
  "accountNickName": "Rainy Day Fund"
}
```

**Responses**

| Status                      | Reason                                                      |
|-----------------------------|-------------------------------------------------------------|
| `201 Created`               | Account created; returns the full account resource          |
| `400 Bad Request`           | Validation failure (missing customer name, nickname length) |
| `422 Unprocessable content` | Business validation error (offensive nickname)              |


### Get Account

```
GET /api/v1/savings-accounts/{accountNumber}
```

**Responses**

| Status | Reason |
|--------|--------|
| `200 OK` | Account found |

## Running Locally

### Prerequisites

- Java 21
- Maven
- PostgreSql database

### PostgreSql database

A PostgreSql database must be set up locally with a schema called `coding_assessment` that contains a table 
named `account`. 
The schema can be created by running the [Create Schema Script](sql/create_schema.sql), be sure to change the place holder password. 


### 1. Start application

```bash
DATABASE_PASSWORD=XXXXX mvn spring-boot:run

```



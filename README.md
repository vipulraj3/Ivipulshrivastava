# Java Fundamentals Backend API

A comprehensive REST API backend for Java fundamental programming applications built with Spring Boot.

## 🚀 Features

- **6 Java Application Services** - Population projection, financial calculations, loan computations, lottery games, geometric calculations, and ticket pricing
- **REST API Endpoints** - Complete RESTful API with JSON request/response
- **Database Integration** - H2 in-memory database for execution history storage
- **Input Validation** - Comprehensive validation for all application inputs
- **Interactive Frontend** - Web-based demo interface for testing applications
- **Execution History** - Track and retrieve past application executions
- **Error Handling** - Robust error handling with meaningful error messages

## 📋 API Endpoints

### Base URL: `http://localhost:8080/api/v1`

| Endpoint | Method | Description |
|----------|--------|-------------|
| `/` | GET | API information and endpoint list |
| `/applications` | GET | Get list of available applications |
| `/execute` | POST | Execute an application |
| `/history` | GET | Get execution history |
| `/result/{id}` | GET | Get specific execution result by ID |
| `/health` | GET | Health check endpoint |

## 🔧 Available Applications

### 1. Population Projection (`population-projection`)
Calculate population growth over time based on birth, death, and immigration rates.

**Input Parameters:**
- `years` (required): Number of years to project (1-50)
- `currentPopulation` (optional): Starting population (default: 312,032,486)

**Example Request:**
```json
{
  "applicationType": "population-projection",
  "inputData": {
    "years": 5,
    "currentPopulation": 100000000
  }
}
```

### 2. Financial Application (`financial-application`)
Calculate compound interest with monthly deposits.

**Input Parameters:**
- `months` (required): Number of months (1-600)
- `monthlyDeposit` (optional): Monthly deposit amount (default: $100)
- `annualInterestRate` (optional): Annual interest rate percentage (default: 3.75%)

**Example Request:**
```json
{
  "applicationType": "financial-application",
  "inputData": {
    "months": 12,
    "monthlyDeposit": 150,
    "annualInterestRate": 4.0
  }
}
```

### 3. Ticket Price (`ticket-price`)
Calculate ticket price based on age.

**Input Parameters:**
- `age` (required): Age in years (0-150)

**Example Request:**
```json
{
  "applicationType": "ticket-price",
  "inputData": {
    "age": 25
  }
}
```

### 4. Compute Loan (`compute-loan`)
Calculate loan payment details.

**Input Parameters:**
- `annualInterestRate` (required): Annual interest rate percentage (0-100)
- `numberOfYears` (required): Loan term in years (1-50)
- `loanAmount` (required): Principal loan amount

**Example Request:**
```json
{
  "applicationType": "compute-loan",
  "inputData": {
    "annualInterestRate": 5.5,
    "numberOfYears": 30,
    "loanAmount": 250000
  }
}
```

### 5. Lottery (`lottery`)
Play a two-digit lottery game.

**Input Parameters:**
- `guess` (required): Your two-digit guess (0-99)

**Example Request:**
```json
{
  "applicationType": "lottery",
  "inputData": {
    "guess": 42
  }
}
```

### 6. Compute Angles (`compute-angles`)
Calculate triangle angles from three points.

**Input Parameters:**
- `x1`, `y1` (required): First point coordinates
- `x2`, `y2` (required): Second point coordinates
- `x3`, `y3` (required): Third point coordinates

**Example Request:**
```json
{
  "applicationType": "compute-angles",
  "inputData": {
    "x1": 0, "y1": 0,
    "x2": 3, "y2": 0,
    "x3": 0, "y3": 4
  }
}
```

## 📦 Response Format

All successful executions return a response in this format:

```json
{
  "applicationType": "application-name",
  "inputData": { /* input parameters */ },
  "outputData": { /* calculation results */ },
  "timestamp": "2025-08-21T18:06:31.123456789",
  "status": "SUCCESS",
  "errorMessage": null,
  "resultId": 1
}
```

Error responses:

```json
{
  "applicationType": "application-name",
  "inputData": null,
  "outputData": null,
  "timestamp": "2025-08-21T18:06:31.123456789",
  "status": "ERROR",
  "errorMessage": "Detailed error description",
  "resultId": null
}
```

## 🛠️ Technology Stack

- **Spring Boot 3.2.0** - Main framework
- **Java 17** - Programming language
- **Spring Data JPA** - Database integration
- **H2 Database** - In-memory database
- **Jackson** - JSON serialization
- **Maven** - Dependency management
- **JUnit 5** - Testing framework

## 🏃‍♂️ Running the Application

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Steps
1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Ivipulshrivastava
   ```

2. **Build the application**
   ```bash
   mvn clean compile
   ```

3. **Run tests**
   ```bash
   mvn test
   ```

4. **Start the application**
   ```bash
   mvn spring-boot:run
   ```

5. **Access the application**
   - API: http://localhost:8080/api/v1/
   - Frontend Demo: http://localhost:8080/api/
   - H2 Console: http://localhost:8080/api/h2-console

## 🧪 Testing the API

### Using curl

```bash
# Get available applications
curl -X GET http://localhost:8080/api/v1/applications

# Execute population projection
curl -X POST http://localhost:8080/api/v1/execute \
  -H "Content-Type: application/json" \
  -d '{
    "applicationType": "population-projection",
    "inputData": {"years": 5}
  }'

# Get execution history
curl -X GET http://localhost:8080/api/v1/history
```

### Using the Web Interface

1. Open http://localhost:8080/api/ in your browser
2. Select an application from the available cards
3. Fill in the required parameters
4. Click "Execute Application"
5. View results and execution history

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/ivipulshrivastava/backend/
│   │   ├── FundamentalsBackendApplication.java
│   │   ├── controller/
│   │   │   └── ApplicationController.java
│   │   ├── service/
│   │   │   ├── ApplicationService.java
│   │   │   ├── ApplicationRegistry.java
│   │   │   ├── ApplicationExecutor.java
│   │   │   ├── PopulationProjectionExecutor.java
│   │   │   ├── FinancialApplicationExecutor.java
│   │   │   ├── TicketPriceExecutor.java
│   │   │   ├── ComputeLoanExecutor.java
│   │   │   ├── LotteryExecutor.java
│   │   │   └── ComputeAnglesExecutor.java
│   │   ├── model/
│   │   │   └── CalculationResult.java
│   │   ├── repository/
│   │   │   └── CalculationResultRepository.java
│   │   ├── dto/
│   │   │   ├── ApplicationRequest.java
│   │   │   └── ApplicationResponse.java
│   │   └── config/
│   │       └── ApplicationConfig.java
│   └── resources/
│       ├── application.properties
│       └── static/
│           └── index.html
└── test/
    └── java/com/ivipulshrivastava/backend/
        └── service/
            └── PopulationProjectionExecutorTest.java
```

## 🔍 Database Schema

### calculation_results table
- `id` (BIGINT) - Primary key
- `application_type` (VARCHAR) - Type of application executed
- `input_data` (TEXT) - JSON input parameters
- `output_data` (TEXT) - JSON output results
- `timestamp` (TIMESTAMP) - Execution timestamp
- `client_ip` (VARCHAR) - Client IP address

## 🎯 Key Features

### Input Validation
- Range validation for numerical inputs
- Required field validation
- Type validation
- Custom business rule validation

### Error Handling
- Comprehensive exception handling
- Meaningful error messages
- HTTP status code mapping
- Logging for debugging

### Extensibility
- Easy to add new applications
- Modular executor pattern
- Configurable through Spring properties
- Database-agnostic design

## 📈 Monitoring & Logging

- Application logs available in console
- Database queries logged (configurable)
- Execution history stored persistently
- Health check endpoint for monitoring

## 🔮 Future Enhancements

1. **Authentication & Authorization**
2. **Rate Limiting**
3. **API Documentation with Swagger**
4. **Docker Support**
5. **PostgreSQL/MySQL Support**
6. **Caching Layer**
7. **Metrics & Monitoring**
8. **API Versioning**

## 📄 License

This project is part of the Java Fundamentals learning repository.
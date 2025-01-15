
# Distance Calculator

A simple Spring Boot application that sums two distances (in **Meters** or **Yards**) and returns the total distance in a specified unit.


## Project Overview

This application demonstrates how to:

- Accept two distances with their respective units (**YARDS** or **METERS**).
- Convert both to a common unit (Meters), sum them, and then convert to the desired output unit.
- Provide a REST endpoint to handle conversion requests and return the calculated total distance as a JSON response.

**Technologies used**:
- Java 21
- Spring Boot 3.4.x
- Gradle (Kotlin DSL)
- Lombok
- JUnit 5

---

## Getting Started

### Prerequisites

- Java 21 (or a compatible Java 21 JDK)
- Gradle is already included via the Gradle Wrapper (`gradlew`/`gradlew.bat`)
- Git (optional, if you’re cloning this repo)

### Clone the Repository

```bash
git clone https://github.com/<your-username>/distance-calculator.git
cd distance-calculator
```

*(Adjust the URL above to point to your actual repository.)*

---

## Build & Run

### Build

```bash
./gradlew clean build
```

*(On Windows, you might need `gradlew.bat clean build`.)*

### Run

```bash
./gradlew bootRun
```

By default, the application starts on **port 8080**.  
You can also run the **main class** (`DistanceCalculatorApplication`) directly from your IDE (e.g., IntelliJ, Eclipse).

#### Configuration

If you want to change the port or other Spring Boot properties, edit:
```
src/main/resources/application.properties
```

For example:
```properties
server.port=8081
```

---

## Endpoints

| Method | Path               | Description                                                   |
|--------|--------------------|---------------------------------------------------------------|
| POST   | `/api/distance/sum` | Accepts two distances (and units), returns the sum result     |

### Example Request/Response

**POST** `http://localhost:8080/api/distance/sum`

**Request Body (JSON)**:
```json
{
  "distance1": 3.0,
  "unit1": "YARDS",
  "distance2": 5.0,
  "unit2": "METERS",
  "outputUnit": "METERS"
}
```

**Example Response (JSON)**:
```json
{
  "totalDistance": 7.74,
  "unit": "METERS"
}
```
*(The numeric value may vary slightly due to floating-point precision.)*

---

## Testing

We use **JUnit 5** for testing.

1. **Run all tests**:
   ```bash
   ./gradlew test
   ```

Check the console output or your IDE’s test panel to see the results.

---

## Project Structure

```
distance-calculator
├─ build.gradle.kts
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com.example.distance_calculator
│  │  │     ├─ DistanceCalculatorApplication.java  # Main application class
│  │  │     ├─ controller
│  │  │     │  └─ DistanceController.java          # REST endpoint
│  │  │     ├─ service
│  │  │     │  └─ DistanceService.java             # Conversion logic
│  │  │     └─ dto
│  │  │        ├─ DistanceRequest.java             # Request DTO
│  │  │        └─ DistanceResponse.java            # Response DTO
│  │  └─ resources
│  │     └─ application.properties                 # Spring Boot config
│  └─ test
│     └─ java
│        └─ com.example.distance_calculator
│           ├─ service
│           │  └─ DistanceServiceTest.java         # Unit tests for service
│           
└─ README.md
```



## License

Made by Oliver Sim.

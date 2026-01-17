# Book Collection Service

A simple Spring Boot project for managing books and categories.


---

## Prerequisites

- Java 21 or later
- Maven 3.9+
- Optional: IDE like IntelliJ IDEA or Eclipse
- Optional: Postman or any API client to test endpoints

---

## Running the Application

1. **Clone the repository**

```bash
git clone https://github.com/abushaista/book-management-service.git
cd book-management-service
```
2. **Build the project**

```bash
mvn clean install
```
3. **Run the application**

```bash
mvn spring-boot:run
```
4. **Test API Endpoints**
- Base URL: http://localhost:8080/api
- Example endpoints:
  - GET /api/books
  - POST /api/books
  - GET /api/categories
  - POST /api/categories
### Build Docker Image (Optional)
```bash
docker build -t book-collection-service .
docker run -p 8080:8080 book-collection-service
```
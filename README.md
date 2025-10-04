# ProofOfConceptKotlin

This is a simple Kotlin Spring Boot REST API for managing books. The application exposes endpoints to create, read, update, delete, and search for books.

## How the App Works

- The app is built with Kotlin and Spring Boot.
- It exposes RESTful endpoints under `/api/books`.
- The main controller is `BookController`, which delegates business logic to a service layer.
- Data is transferred using `BookDto` objects.

## API Endpoints

### List Books
- **GET** `/api/books`
- **Query Parameter:** `q` (optional) — If provided, filters books by title.
- **Response:** `200 OK` with a list of books.

### Get Book by ID
- **GET** `/api/books/{id}`
- **Path Variable:** `id` — The ID of the book.
- **Response:** `200 OK` with the book details.

### Create Book
- **POST** `/api/books`
- **Request Body:** JSON representing a `BookDto`.
- **Response:** `200 OK` with the created book.

### Update Book
- **PUT** `/api/books/{id}`
- **Path Variable:** `id` — The ID of the book.
- **Request Body:** JSON representing a `BookDto`.
- **Response:** `200 OK` with the updated book.

### Delete Book
- **DELETE** `/api/books/{id}`
- **Path Variable:** `id` — The ID of the book.
- **Response:** `200 OK` (empty body).

## Running the App

1. Make sure you have Java and Gradle installed.
2. Build the project:
   ```bash
   ./gradlew build
   ```
3. Run the application:
   ```bash
   ./gradlew bootRun
   ```
4. The API will be available at `http://localhost:8080/api/books`.

## Example `BookDto` JSON
```json
{
  "id": 1,
  "title": "Example Book",
  "author": "Author Name",
  "publishedDate": "2025-01-01"
}
```

---

Feel free to explore and extend the application as needed!
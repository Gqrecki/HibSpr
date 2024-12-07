package org.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    // In-memory list to store books (you can replace it with a database)
    private List<Book> books = new ArrayList<>();

    // GET endpoint to fetch all books
    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    // POST endpoint to add a new book
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    // A simple GET endpoint to fetch a book by its ID (for testing purposes)
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        if (id >= 0 && id < books.size()) {
            return ResponseEntity.ok(books.get(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Book model (you can add more fields as needed)
    public static class Book {
        private String title;
        private String author;

        // Constructors, getters, and setters
        public Book() {}

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
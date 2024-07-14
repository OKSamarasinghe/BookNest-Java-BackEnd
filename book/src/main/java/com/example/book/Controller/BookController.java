package com.example.book.Controller;

import com.example.book.Data.Books;
import com.example.book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(path = "/books")
    public List<Books> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping(path = "/books")
    public Books createBook(@RequestBody Books book) {
        return bookService.createBook(book);
    }

    @GetMapping(path = "/books/{id}")
    public Books getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }


    @DeleteMapping(path = "/books/{id}")
    public void deleteBooksById(@PathVariable int id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "/books/{id}")
    public Books updateBook(@RequestBody Books books){
        return bookService.updateBook(books);
    }

    @GetMapping(path = "/books", params = "name")
    public List<Books> findBooksByName(@RequestParam String name) {
        return bookService.findBooksByName(name);
    }

    @GetMapping(path = "/books/names")
    public List<String> getAllBookNames() {
        return bookService.getAllBookNames();
    }

    // BookController.java

    @GetMapping("/books/isbn/{isbn}")
    public boolean checkISBNExistence(@PathVariable int isbn) {
        return bookService.getAllISBNs().contains(isbn);
    }

    @GetMapping("/books/price/{price}")
    public boolean checkPriceExistence(@PathVariable float price) {
        return bookService.getAllUnitPrices().contains(price);
    }
    @GetMapping("/books/isbn")
    public Integer getISBNByName(@RequestParam String name) {
        return bookService.getISBNByName(name);
    }
    @GetMapping("/books/price")
    public float getPriceByName(@RequestParam String name) {
        return bookService.getPriceByName(name);
    }
    @GetMapping("/books/quantity")
    public float getBookQuantityByName(@RequestParam String name) {
        return bookService.getBookQuantityByName(name);
    }

}

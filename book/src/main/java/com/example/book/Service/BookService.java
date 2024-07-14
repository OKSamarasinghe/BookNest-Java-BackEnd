package com.example.book.Service;

import com.example.book.Data.BookRepository;
import com.example.book.Data.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;


    @GetMapping(path = "/books")
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public Books updateBook(Books books){
        return bookRepository.save(books);
    }

    public Books getBookById(int id) {
        Optional<Books>books = bookRepository.findById(id);
        if(books.isPresent()){
            return books.get();
        }
        return null;
    }

    public Books createBook(Books book) {
        return bookRepository.save(book);
    }

    public List<Books> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Books> findBooksByName(String name) {
        return bookRepository.findBooksByName(name);
    }

    public List<String> getAllBookNames() {
        return bookRepository.findAll().stream()
                .map(Books::getName)
                .collect(Collectors.toList());
    }

    // BookService.java

    public List<Integer> getAllISBNs() {
        List<Books> books = bookRepository.findAll();
        return books.stream().map(Books::getIsbn).collect(Collectors.toList());
    }

    public List<Float> getAllUnitPrices() {
        List<Books> books = bookRepository.findAll();
        return books.stream().map(Books::getPrice).collect(Collectors.toList());
    }
    public Integer getISBNByName(String name) {
        Books book = bookRepository.findByName(name);
        if (book != null) {
            return book.getIsbn();
        }
        return null; // Or handle the case where the book with the given name is not found
    }
    public Float getPriceByName(String name) {
        Books book = bookRepository.findByName(name);
        if (book != null) {
            return book.getPrice();
        }
        return null; // Or handle the case where the book with the given name is not found
    }

    public Integer getBookQuantityByName(String name) {
        Books book = bookRepository.findByName(name);
        if (book != null) {
            return book.getQuantity();
        }
        return null; // Or handle the case where the book with the given name is not found
    }
}

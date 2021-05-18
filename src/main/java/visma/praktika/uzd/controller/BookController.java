package visma.praktika.uzd.controller;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import visma.praktika.uzd.dto.Books;
import visma.praktika.uzd.service.books.BookService;

import java.io.IOException;

@RestController
public class BookController{
    private final BookService bookService;
    public BookController(@Autowired BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping("/newbook")
    public Books newBook(String name, String author, String category, String language, String publicationDate, String ISBN) throws IOException, ParseException {
        bookService.addBook(name, author, category, language, publicationDate, ISBN);
        return null;
    }
    @PostMapping("/takebook")
    public String takeBook(String name, String username, String takeDate, String returnDate) throws IOException {
        bookService.takeBook(name, username, takeDate, returnDate);
        return null;
    }
    @GetMapping("/getbookbyGUID")
    public Books getBookByGUID(String GUID) throws IOException {
        bookService.getBookByGUID(GUID);
        return null;
    }
    @GetMapping("/filterbooks")
    public Books filterBooks(String filterBy, String secondFilter) throws IOException {
        bookService.filterBooks(filterBy, secondFilter);
        return null;
    }
    @DeleteMapping("/deletebook")
    public void deleteBook(String name) throws IOException {
        bookService.deleteBook(name);
    }
}
package cz.greenrose.bookshelf.controllers;

import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookshelf;
import cz.greenrose.bookshelf.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/v1/book")
    public ResponseEntity<List<Bookshelf>> getAllBooks(){
        return new ResponseEntity<>(this.bookService.getAllBooks(), HttpStatus.OK);
    }
}

package cz.greenrose.bookshelf.controllers;

import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/api/v1/book")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return new ResponseEntity<>(this.bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/book/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Integer bookId){
        return new ResponseEntity<>(this.bookService.getBookDTOById(bookId), HttpStatus.OK);
    }

    @PostMapping("/api/v1/book")
    public ResponseEntity<BookDTO> postNewBook(@RequestBody BookDTO book){
        return new ResponseEntity<>(this.bookService.saveBookWithAuthors(book), HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/v1/book/{bookId}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Integer bookId, @RequestBody BookDTO bookDTO){
        return new ResponseEntity<>(this.bookService.updateBook(bookId, bookDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/v1/book/{bookId}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Integer bookId){
        return new ResponseEntity<>(this.bookService.deleteBook(bookId), HttpStatus.ACCEPTED);
    }
}

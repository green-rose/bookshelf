package cz.greenrose.bookshelf.controllers;
import cz.greenrose.bookshelf.DTO.AuthorDTO;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.services.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/api/v1/author")
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(){
        return new ResponseEntity<>(this.authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/author/{authorId}")
    public ResponseEntity<AuthorDTO> getauthorById(@PathVariable Integer authorId){
        return new ResponseEntity<>(this.authorService.getauthorById(authorId), HttpStatus.OK);
    }

    @PostMapping("/api/v1/author")
    public ResponseEntity<AuthorDTO> postNewAuthor(@RequestBody AuthorDTO author){
        return new ResponseEntity<>(this.authorService.savePost(author), HttpStatus.ACCEPTED);
    }
}

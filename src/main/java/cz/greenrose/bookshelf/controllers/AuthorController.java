package cz.greenrose.bookshelf.controllers;
import cz.greenrose.bookshelf.DTO.AuthorDTO;
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
    public ResponseEntity<List<AuthorDTO>> getAllAuthors(@RequestParam(required = false) Integer page){
        if (page == null) page = 0;
        return new ResponseEntity<>(this.authorService.getAllAuthors(page), HttpStatus.OK);
    }

    @GetMapping("/api/v1/author/{authorId}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Integer authorId){
        return new ResponseEntity<>(this.authorService.getAuthorDTOById(authorId), HttpStatus.OK);
    }

    @PostMapping("/api/v1/author")
    public ResponseEntity<AuthorDTO> postNewAuthor(@RequestBody AuthorDTO author){
        return new ResponseEntity<>(this.authorService.saveAuthor(author), HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/v1/author/{idAuthor}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Integer idAuthor, @RequestBody AuthorDTO author){
        return new ResponseEntity<>(this.authorService.updateAuthor(idAuthor, author), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/v1/author/{idAuthor}")
    public ResponseEntity<AuthorDTO> deleteAuthor(@PathVariable Integer idAuthor){
        return new ResponseEntity<>(this.authorService.deleteAuthor(idAuthor), HttpStatus.ACCEPTED);
    }
}

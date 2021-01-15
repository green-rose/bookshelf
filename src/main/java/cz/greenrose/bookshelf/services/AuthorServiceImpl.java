package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors(){

        return this.authorRepository.findAll();
    }
}

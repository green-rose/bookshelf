package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Author;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<Author> getAllAuthors();
}

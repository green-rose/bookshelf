package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Bookshelf;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    List<Bookshelf> getAllBooks();

}

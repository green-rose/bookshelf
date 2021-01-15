package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookshelf;
import cz.greenrose.bookshelf.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Bookshelf> getAllBooks(){
        return this.bookRepository.findAll();
    }
}

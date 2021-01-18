package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateBookDTO;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks(){
        List<Book> books= this.bookRepository.findAll();
        List<BookDTO> booksDTO = new ArrayList<>();
        books.forEach(book -> booksDTO.add(CreateBookDTO.createBookDTOFromBook(book)));
        return booksDTO;
    }

    @Override
    public BookDTO getBookById(Integer bookId) {
        Book book = this.bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            throw new NoIDFoundException("Book id doesn't exist...");
        }
        return CreateBookDTO.createBookDTOFromBook(book);
    }
}

package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.InvalidEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateBookDTO;
import cz.greenrose.bookshelf.models.*;
import cz.greenrose.bookshelf.repositories.*;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    public BookRepository bookRepository;
    public AuthorRepository authorRepository;
    public SeriesService seriesService;
    public PublisherService publisherService;
    private BookshelfService bookshelfService;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           SeriesService seriesService,
                           PublisherService publisherService,
                           BookshelfService bookshelfService) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.seriesService = seriesService;
        this.publisherService = publisherService;
        this.bookshelfService = bookshelfService;
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

    @Override
    public BookDTO saveBookWithAuthors(BookDTO bookDTO) {

            Book book = CreateBookDTO.createBookFromBookDTO(bookDTO, this.seriesService, this.publisherService);
            if (this.bookRepository.findFirstByBookTitleAndPublisherAndYearAndEditionNumberAndLanguage(
                    book.getBookTitle(), book.getPublisher(), book.getYear(), book.getEditionNumber(), book.getLanguage()).orElse(null) != null) {
                throw new DuplicateEntryException("Book already exists...");
            }
            Book newBook = this.bookRepository.save(book);
            try {
                bookDTO.getBookAuthors().forEach(bookAuthor -> {
                    this.bookshelfService.addAuthorDTOsToBook(newBook,bookAuthor);
                });
            }catch(Exception e){
                throw new InvalidEntryException("Author to book couldn't be added ...");
            }
            return CreateBookDTO.createBookDTOFromBook(this.bookRepository.getOne(newBook.getId()));

    }
}

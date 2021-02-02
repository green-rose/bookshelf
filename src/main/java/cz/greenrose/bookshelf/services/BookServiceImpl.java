package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorBookshelfDTO;
import cz.greenrose.bookshelf.exceptions.CantDeleteException;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.InvalidEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateBookDTO;
import cz.greenrose.bookshelf.models.*;
import cz.greenrose.bookshelf.repositories.*;

import org.springframework.dao.DataIntegrityViolationException;
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


    private Book getBookById(Integer bookId) {
        Book book = this.bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            throw new NoIDFoundException("Book id doesn't exist...");
        }
        return book;
    }

    @Override
    public BookDTO getBookDTOById(Integer bookId) {
        return CreateBookDTO.createBookDTOFromBook(this.getBookById(bookId));
    }

    private void saveAuthorsToBook(List<AuthorBookshelfDTO> bookAuthors, Book book){
        try {
            bookAuthors.forEach(bookAuthor -> {
                this.bookshelfService.addAuthorDTOsToBook(book,bookAuthor);
            });
        }catch(Exception e){
            throw new InvalidEntryException("Author to book couldn't be added ...");
        }
    }
    @Override
    public BookDTO saveBookWithAuthors(BookDTO bookDTO) {

            Book book = CreateBookDTO.createBookFromBookDTO(bookDTO, this.seriesService, this.publisherService);
            if (this.bookRepository.findFirstByBookTitleAndPublisherAndYearAndEditionNumberAndLanguage(
                    book.getBookTitle(), book.getPublisher(), book.getYear(), book.getEditionNumber(), book.getLanguage()).orElse(null) != null) {
                throw new DuplicateEntryException("Book already exists...");
            }
            Book newBook = this.bookRepository.save(book);
            this.saveAuthorsToBook(bookDTO.getBookAuthors(),newBook);
            return CreateBookDTO.createBookDTOFromBook(this.bookRepository.getOne(newBook.getId()));

    }

    @Override
    public BookDTO updateBook(Integer bookId, BookDTO bookDTO) {
        Book book= this.getBookById(bookId);
        Book duplicateBook = this.bookRepository.findFirstByBookTitleAndPublisherAndYearAndEditionNumberAndLanguage(
                book.getBookTitle(), book.getPublisher(), book.getYear(), book.getEditionNumber(), book.getLanguage()).orElse(null);
        if (duplicateBook!=null && !duplicateBook.equals(book)) {
            throw new DuplicateEntryException("Book already exists...");
        }
        this.bookshelfService.deleteAuthorsFromBook(book);
        this.saveAuthorsToBook(bookDTO.getBookAuthors(),book);
        book.setBookTitle(bookDTO.getBookTitle());
        book.setYear(bookDTO.getYear());
        book.setSeries(this.seriesService.findSeries(bookDTO.getSeries()));
        book.setPublisher(this.publisherService.findPublisher(bookDTO.getPublisher()));
        book.setYear(bookDTO.getYear());
        book.setLanguage(bookDTO.getLanguage());
        book.setEpisodeNumber(bookDTO.getEpisodeNumber());
        book.setEditionNumber(bookDTO.getEditionNumber());
        return CreateBookDTO.createBookDTOFromBook(this.bookRepository.save(book));
    }

    @Override
    public BookDTO deleteBook(Integer bookId) {
        BookDTO bookDTO = this.getBookDTOById(bookId);
        try {
            bookRepository.delete(this.getBookById(bookId));
        } catch (DataIntegrityViolationException e){
            throw new CantDeleteException("Book can't be deleted...");
        }
        return bookDTO;
    }

}

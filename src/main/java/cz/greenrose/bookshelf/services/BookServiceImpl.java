package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorBookauthorDTO;
import cz.greenrose.bookshelf.exceptions.CantDeleteException;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.InvalidEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateBookDTO;
import cz.greenrose.bookshelf.models.*;
import cz.greenrose.bookshelf.repositories.*;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class BookServiceImpl implements BookService {

    public BookRepository bookRepository;
    public AuthorRepository authorRepository;
    public SeriesService seriesService;
    public PublisherService publisherService;
    private final BookauthorService bookshelfService;

    public BookServiceImpl(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           SeriesService seriesService,
                           PublisherService publisherService,
                           BookauthorService bookshelfService) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.seriesService = seriesService;
        this.publisherService = publisherService;
        this.bookshelfService = bookshelfService;
    }

    @Override
    public List<BookDTO> getAllBooks(Integer page){
        Page<Book> books= this.bookRepository.findAll(PageRequest.of(page, 10));
        List<BookDTO> booksDTO = new ArrayList<>();
        books.forEach(book -> booksDTO.add(CreateBookDTO.createBookDTOFromBook(book)));
        return booksDTO;
    }


    private Book getBookById(Integer bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(()->new NoIDFoundException("Book id doesn't exist..."));
    }

    @Override
    public BookDTO getBookDTOById(Integer bookId) {
        return CreateBookDTO.createBookDTOFromBook(this.getBookById(bookId));
    }

    private void saveAuthorsToBook(List<AuthorBookauthorDTO> bookAuthors, Book book){
        try {
            bookAuthors.forEach(bookAuthor -> {
                this.bookshelfService.addAuthorDTOsToBook(book,bookAuthor);
            });
        }catch(Exception e){
            throw new InvalidEntryException("Author to book couldn't be added ..." + e.getMessage());
        }
    }
    @Override
    @Transactional
    public BookDTO saveBookWithAuthors(BookDTO bookDTO) {
            Book book = CreateBookDTO.createBookFromBookDTO(bookDTO, this.seriesService, this.publisherService);
            if (this.bookRepository.findFirstByBookTitleAndPublisherAndYearAndEditionNumberAndLanguage(
                    book.getBookTitle(), book.getPublisher(), book.getYear(), book.getEditionNumber(), book.getLanguage()).orElse(null) != null) {
                throw new DuplicateEntryException("Book already exists...");
            }
            Book newBook = this.bookRepository.save(book);
            this.saveAuthorsToBook(bookDTO.getBookAuthors(),newBook);
            return CreateBookDTO.createBookDTOFromBook(this.bookRepository.findById(newBook.getId()).orElseThrow(()->new InvalidEntryException("Author to book couldn't be added ...")));

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

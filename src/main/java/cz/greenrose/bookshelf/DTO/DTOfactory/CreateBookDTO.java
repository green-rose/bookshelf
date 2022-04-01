package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.AuthorBookauthorDTO;
import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.services.PublisherService;
import cz.greenrose.bookshelf.services.SeriesService;

import java.util.ArrayList;
import java.util.List;

public class CreateBookDTO {
    public static BookDTO createBookDTOFromBook(Book book){

        BookDTO bookDTO = new BookDTO();
        List<AuthorBookauthorDTO> authorBookauthorDTO = new ArrayList<>();

        book.authorsOfBook.forEach(
                bookauthor -> authorBookauthorDTO.add(
                        CreateAuthorBookauthorDTO.CreateAuthorBookauthorDTOFromBookauthor(bookauthor)));

        bookDTO.setBookAuthors(authorBookauthorDTO);
        bookDTO.setBookTitle(book.getBookTitle());
        bookDTO.setBookId(book.getId());
        bookDTO.setEditionNumber(book.getEditionNumber());
        bookDTO.setYear(book.getYear());
        bookDTO.setEpisodeNumber(book.getEpisodeNumber());
        bookDTO.setLanguage(book.getLanguage());
        bookDTO.setPublisher(new PublisherDTO(
                book.getPublisher().getId(),book.getPublisher().getPublisher()));
        bookDTO.setSeries(new SeriesDTO(
                book.getSeries().getId(),book.getSeries().getSeries()));

        return bookDTO;
    }

    public static Book createBookFromBookDTO(BookDTO bookDTO, SeriesService seriesService, PublisherService publisherService){
        Book book = new Book();
        book.setBookTitle(bookDTO.getBookTitle());
        book.setEditionNumber(bookDTO.getEditionNumber());
        book.setEpisodeNumber(bookDTO.getEpisodeNumber());
        book.setLanguage(bookDTO.getLanguage());
        book.setSeries(seriesService.findSeries(bookDTO.getSeries()));
        book.setPublisher(publisherService.findPublisher(bookDTO.getPublisher()));
        book.setYear(bookDTO.getYear());
        return book;
    }

}

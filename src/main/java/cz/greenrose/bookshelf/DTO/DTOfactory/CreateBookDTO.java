package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.AuthorBookshelfDTO;
import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.models.Book;

import java.util.ArrayList;
import java.util.List;

public class CreateBookDTO {
    public static BookDTO createBookDTOFromBook(Book book){

        BookDTO bookDTO = new BookDTO();
        List<AuthorBookshelfDTO> authorBookshelfDTO = new ArrayList<>();

        book.authorsOfBook.forEach(
                bookshelf -> authorBookshelfDTO.add(
                        CreateAuthorBookshelfDTO.CreateAuthorBookshelfDTOFromBookshelf(bookshelf)));

        bookDTO.setBookAuthors(authorBookshelfDTO);
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

}

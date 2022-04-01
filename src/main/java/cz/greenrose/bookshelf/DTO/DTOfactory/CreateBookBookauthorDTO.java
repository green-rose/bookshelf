package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.BookBookauthorDTO;
import cz.greenrose.bookshelf.models.Bookauthor;

public class CreateBookBookauthorDTO {
    public static BookBookauthorDTO CreateBookBookauthorDTOFromBookauthor(Bookauthor bookauthor){
        BookBookauthorDTO bookBookshelfDTO = new BookBookauthorDTO();
        bookBookshelfDTO.setBookTitle(bookauthor.getBook().getBookTitle());
        bookBookshelfDTO.setBookId(bookauthor.getBook().getId());
        bookBookshelfDTO.setEditor(bookauthor.getEditor());
        bookBookshelfDTO.setMainAuthor(bookauthor.getMainAuthor());

        return bookBookshelfDTO;
    }

}

package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.BookBookshelfDTO;
import cz.greenrose.bookshelf.models.Bookshelf;

public class CreateBookBookshelfDTO {
    public static BookBookshelfDTO CreateBookBookshelfDTOFromBookshelf(Bookshelf bookshelf){
        BookBookshelfDTO bookBookshelfDTO = new BookBookshelfDTO();
        bookBookshelfDTO.setBookTitle(bookshelf.getBook().getBookTitle());
        bookBookshelfDTO.setBookId(bookshelf.getBook().getId());
        bookBookshelfDTO.setEditor(bookshelf.getEditor());
        bookBookshelfDTO.setMainAuthor(bookshelf.getMainAuthor());

        return bookBookshelfDTO;
    }

}

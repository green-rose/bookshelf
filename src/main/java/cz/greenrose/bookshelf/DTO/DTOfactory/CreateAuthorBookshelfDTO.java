package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.AuthorBookshelfDTO;
import cz.greenrose.bookshelf.models.Bookshelf;

public class CreateAuthorBookshelfDTO {
    public static AuthorBookshelfDTO CreateAuthorBookshelfDTOFromBookshelf(Bookshelf bookshelf){
        AuthorBookshelfDTO authorBookshelfDTO = new AuthorBookshelfDTO();
        authorBookshelfDTO.setSurname(bookshelf.getAuthor().getSurname());
        authorBookshelfDTO.setId(bookshelf.getAuthor().getId());
        authorBookshelfDTO.setNames(bookshelf.getAuthor().getNames());
        authorBookshelfDTO.setWholeNames(bookshelf.getAuthor().getWholeNames());
        authorBookshelfDTO.setEditor(bookshelf.getEditor());
        authorBookshelfDTO.setMainAuthor(bookshelf.getMainAuthor());

        return authorBookshelfDTO;
    }

}

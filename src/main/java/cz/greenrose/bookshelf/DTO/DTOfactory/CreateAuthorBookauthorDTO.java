package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.AuthorBookauthorDTO;
import cz.greenrose.bookshelf.models.Bookauthor;

public class CreateAuthorBookauthorDTO {
    public static AuthorBookauthorDTO CreateAuthorBookauthorDTOFromBookauthor(Bookauthor bookauthor){
        AuthorBookauthorDTO authorBookauthorDTO = new AuthorBookauthorDTO();
        authorBookauthorDTO.setSurname(bookauthor.getAuthor().getSurname());
        authorBookauthorDTO.setId(bookauthor.getAuthor().getId());
        authorBookauthorDTO.setNames(bookauthor.getAuthor().getNames());
        authorBookauthorDTO.setWholeNames(bookauthor.getAuthor().getWholeNames());
        authorBookauthorDTO.setEditor(bookauthor.getEditor());
        authorBookauthorDTO.setMainAuthor(bookauthor.getMainAuthor());

        return authorBookauthorDTO;
    }

}

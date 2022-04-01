package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.*;
import cz.greenrose.bookshelf.models.Author;

import java.util.ArrayList;
import java.util.List;

public class CreateAuthorDTO {
    public static AuthorDTO createAuthorDTOFromAuthor(Author author){

        AuthorDTO authorDTO = new AuthorDTO();

        List<BookBookauthorDTO> bookBookauthorDTO = new ArrayList<>();

        author.bookOfAuthors.forEach(
                bookauthor -> bookBookauthorDTO.add(
                        CreateBookBookauthorDTO.CreateBookBookauthorDTOFromBookauthor(bookauthor)));
        authorDTO.setAuthorBooks(bookBookauthorDTO);
        authorDTO.setId(author.getId());
        authorDTO.setNames(author.getNames());
        authorDTO.setSurname(author.getSurname());
        authorDTO.setWholeNames(author.getWholeNames());

        return authorDTO;
    }

}

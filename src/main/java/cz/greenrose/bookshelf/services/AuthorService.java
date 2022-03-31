package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<AuthorDTO> getAllAuthors(Integer page);
    AuthorDTO getAuthorDTOById(Integer authorId);

    AuthorDTO saveAuthor(AuthorDTO author);

    AuthorDTO updateAuthor(Integer idAuthor, AuthorDTO author);

    AuthorDTO deleteAuthor(Integer idAuthor);
}

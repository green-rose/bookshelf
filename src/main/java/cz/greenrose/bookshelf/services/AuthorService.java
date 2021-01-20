package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getauthorById(Integer authorId);

    AuthorDTO savePost(AuthorDTO author);
}

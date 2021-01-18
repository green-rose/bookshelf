package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorService {
    public List<AuthorDTO> getAllAuthors();
    public AuthorDTO getauthorById(Integer authorId);
}

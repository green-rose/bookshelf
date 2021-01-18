package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateAuthorDTO;
import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> getAllAuthors(){
        List<Author> authors = this.authorRepository.findAll();
        List<AuthorDTO> authorDTO = new ArrayList<>();
        authors.forEach(author -> authorDTO.add(CreateAuthorDTO.createAuthorDTOFromAuthor(author)));
        return authorDTO;
    }

    @Override
    public AuthorDTO getauthorById(Integer authorId) {
        Author author = this.authorRepository.findById(authorId).orElse(null);
        return CreateAuthorDTO.createAuthorDTOFromAuthor(author);
    }
}

package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateAuthorDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreatePublisherDTO;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.models.Publisher;
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
        if (author == null) {
            throw new NoIDFoundException("Author id doesn't exist...");
        }
        return CreateAuthorDTO.createAuthorDTOFromAuthor(author);
    }

    @Override
    public AuthorDTO savePost(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setNames(authorDTO.getNames());
        author.setSurname(authorDTO.getSurname());
        author.setWholeNames(authorDTO.getWholeNames());
        if (this.authorRepository.findFirstByNamesAndAndSurname(authorDTO.getNames(), authorDTO.getSurname()).orElse(null)!=null) {
            throw new DuplicateEntryException("Author already exists...");
        }
        Author newAuthor = this.authorRepository.save(author);
        return CreateAuthorDTO.createAuthorDTOFromAuthor(newAuthor);
    }
}

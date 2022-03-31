package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateAuthorDTO;
import cz.greenrose.bookshelf.exceptions.CantDeleteException;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.repositories.AuthorRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<AuthorDTO> getAllAuthors(Integer page){
        Page<Author> authors = this.authorRepository.findAll(PageRequest.of(page, 10));
        List<AuthorDTO> authorDTO = new ArrayList<>();
        authors.forEach(author -> authorDTO.add(CreateAuthorDTO.createAuthorDTOFromAuthor(author)));
        return authorDTO;
    }

    @Override
    public AuthorDTO getAuthorDTOById(Integer authorId) {
        return CreateAuthorDTO.createAuthorDTOFromAuthor(this.getAuthorById(authorId));
    }

    public Author getAuthorById(Integer authorId) {
        return this.authorRepository.findById(authorId).orElseThrow(()->new NoIDFoundException("Author id doesn't exist..."));
    }

    @Override
    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setNames(authorDTO.getNames());
        author.setSurname(authorDTO.getSurname());
        author.setWholeNames(authorDTO.getWholeNames());
        if (this.authorRepository.findFirstByNamesAndSurname(authorDTO.getNames(), authorDTO.getSurname()).orElse(null)!=null) {
            throw new DuplicateEntryException("Author already exists...");
        }
        Author newAuthor = this.authorRepository.save(author);
        return CreateAuthorDTO.createAuthorDTOFromAuthor(newAuthor);
    }

    @Override
    public AuthorDTO updateAuthor(Integer idAuthor, AuthorDTO authorDTO) {
        Author author= this.getAuthorById(idAuthor);
        Author duplicateAuthor = this.authorRepository.findFirstByNamesAndSurname(authorDTO.getNames(), authorDTO.getSurname()).orElse(null);
        if (duplicateAuthor!=null && !duplicateAuthor.equals(author)) {
            throw new DuplicateEntryException("Author already exists...");
        }
        author.setWholeNames(authorDTO.getWholeNames());
        author.setSurname(authorDTO.getSurname());
        author.setNames(authorDTO.getNames());
        return CreateAuthorDTO.createAuthorDTOFromAuthor(this.authorRepository.save(author));
    }

    @Override
    public AuthorDTO deleteAuthor(Integer idAuthor) {
        AuthorDTO authorDTO = this.getAuthorDTOById(idAuthor);
        try {
            authorRepository.delete(this.getAuthorById(idAuthor));
        } catch (DataIntegrityViolationException e){
            throw new CantDeleteException("Author can't be deleted...");
        }
        return authorDTO;
    }
}

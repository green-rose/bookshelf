package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.AuthorBookshelfDTO;
import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Bookshelf;
import cz.greenrose.bookshelf.repositories.AuthorRepository;
import cz.greenrose.bookshelf.repositories.BookshelfRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookshelfServiceImpl implements BookshelfService{
    private BookshelfRepository bookshelfRepository;
    private AuthorRepository authorRepository;

    public BookshelfServiceImpl(BookshelfRepository bookshelfRepository, AuthorRepository authorRepository) {
        this.bookshelfRepository = bookshelfRepository;
        this.authorRepository = authorRepository;
    }
    public Bookshelf addAuthorDTOsToBook(Book book, AuthorBookshelfDTO authorBookshelfDTO){
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.setBook(book);
        Author author;
        if (authorBookshelfDTO.getId()!=null) {
            author = this.authorRepository.findById(authorBookshelfDTO.getId()).orElse(null);
        } else {
            author = this.authorRepository.findFirstByNamesAndAndSurname(authorBookshelfDTO.getNames(), authorBookshelfDTO.getSurname()).orElse(null);
        };
        bookshelf.setAuthor(author);
        bookshelf.setMainAuthor(authorBookshelfDTO.getMainAuthor());
        bookshelf.setEditor(authorBookshelfDTO.getEditor());

      return this.bookshelfRepository.save(bookshelf);
    }
    @Transactional
    public Integer deleteAuthorsFromBook(Book book){
        return this.bookshelfRepository.deleteAllByBook(book);
    }
}

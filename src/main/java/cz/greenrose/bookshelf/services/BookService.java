package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.BookDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Integer bookId);

    BookDTO saveBookWithAuthors(BookDTO book);
}

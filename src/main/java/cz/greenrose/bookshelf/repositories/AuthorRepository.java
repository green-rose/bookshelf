package cz.greenrose.bookshelf.repositories;

import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Optional<Author> findFirstByNamesAndSurname(String names, String surname);
}

package cz.greenrose.bookshelf.repositories;

import cz.greenrose.bookshelf.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Integer> {

    Optional<Publisher> findFirstByPublisherEquals(String publisher);
}
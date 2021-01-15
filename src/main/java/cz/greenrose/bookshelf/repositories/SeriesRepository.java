package cz.greenrose.bookshelf.repositories;

import cz.greenrose.bookshelf.models.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Series,Integer> {

}

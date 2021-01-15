package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Series;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeriesService {
    List<Series> getAllSeries();
}

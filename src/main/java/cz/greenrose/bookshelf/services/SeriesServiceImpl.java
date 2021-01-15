package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Series;
import cz.greenrose.bookshelf.repositories.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService{

    private SeriesRepository seriesRepository;

    public SeriesServiceImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<Series> getAllSeries() {
        return this.seriesRepository.findAll();
    }
}

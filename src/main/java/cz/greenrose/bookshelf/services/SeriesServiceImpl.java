package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.DTOfactory.CreatePublisherDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateSeriesDTO;
import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.models.Publisher;
import cz.greenrose.bookshelf.models.Series;
import cz.greenrose.bookshelf.repositories.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService{

    private SeriesRepository seriesRepository;

    public SeriesServiceImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<SeriesDTO> getAllSeries() {

        List<Series> allSeries = this.seriesRepository.findAll();
        List<SeriesDTO> allSeriesDTO = new ArrayList<>();
        allSeries.forEach(series -> allSeriesDTO.add(CreateSeriesDTO.createSeriesDTOFromSeries(series)));
        return allSeriesDTO;

    }

    @Override
    public SeriesDTO getSeriesById(Integer idSeries) {
        Series series = this.seriesRepository.findById(idSeries).orElse(null);
        if (series == null) {
            throw new NoIDFoundException("Series id doesn't exist...");
        }
        return CreateSeriesDTO.createSeriesDTOFromSeries(series);
    }
}

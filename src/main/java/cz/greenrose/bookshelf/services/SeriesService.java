package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.models.Series;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeriesService {
    List<SeriesDTO> getAllSeries();

    SeriesDTO getSeriesById(Integer idSeries);

    SeriesDTO saveSeries(SeriesDTO series);

    Series findSeries(SeriesDTO series);
}

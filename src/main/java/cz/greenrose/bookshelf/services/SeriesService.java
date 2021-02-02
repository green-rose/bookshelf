package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.models.Series;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public interface SeriesService {
    List<SeriesDTO> getAllSeries();

    SeriesDTO getSeriesDTOById(Integer idSeries);

    SeriesDTO saveSeries(SeriesDTO series);

    Series findSeries(SeriesDTO series);

    SeriesDTO updateSeries(Integer idSeries, SeriesDTO series);

    SeriesDTO deleteSeries(Integer idSeries);
}

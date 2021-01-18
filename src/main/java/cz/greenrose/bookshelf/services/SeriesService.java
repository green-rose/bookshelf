package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.SeriesDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SeriesService {
    List<SeriesDTO> getAllSeries();

    SeriesDTO getSeriesById(Integer idSeries);
}

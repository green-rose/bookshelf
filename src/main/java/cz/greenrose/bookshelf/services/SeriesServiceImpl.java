package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.DTOfactory.CreateSeriesDTO;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.exceptions.CantDeleteException;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.models.Series;
import cz.greenrose.bookshelf.repositories.SeriesRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService{

    private final SeriesRepository seriesRepository;

    public SeriesServiceImpl(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @Override
    public List<SeriesDTO> getAllSeries(Integer page) {

        Page<Series> allSeries = this.seriesRepository.findAll(PageRequest.of(page, 10));
        List<SeriesDTO> allSeriesDTO = new ArrayList<>();
        allSeries.forEach(series -> allSeriesDTO.add(CreateSeriesDTO.createSeriesDTOFromSeries(series)));
        return allSeriesDTO;

    }

    @Override
    public SeriesDTO getSeriesDTOById(Integer idSeries) {

        return CreateSeriesDTO.createSeriesDTOFromSeries(this.getSeriesById(idSeries));
    }

    public Series getSeriesById(Integer idSeries) {
        return this.seriesRepository.findById(idSeries).orElseThrow(()->new NoIDFoundException("Series id doesn't exist..."));
    }


    @Override
    public SeriesDTO saveSeries(SeriesDTO seriesDTO){
        Series series = new Series();
        series.setSeries(seriesDTO.getSeries());
        if (this.seriesRepository.findFirstBySeriesEquals(seriesDTO.getSeries()).orElse(null)!=null) {
            throw new DuplicateEntryException("Series already exists...");
        }
        Series newSeries = this.seriesRepository.save(series);
        return CreateSeriesDTO.createSeriesDTOFromSeries(newSeries);
    }

    @Override
    public Series findSeries(SeriesDTO seriesDTO) {
        if (this.seriesRepository.findFirstBySeriesEquals(seriesDTO.getSeries()).orElse(null)!=null){
            return this.seriesRepository.findFirstBySeriesEquals(seriesDTO.getSeries()).orElse(null);
        }
        Series series = new Series();
        series.setSeries(seriesDTO.getSeries());
        return this.seriesRepository.save(series);
    }

    @Override
    public SeriesDTO updateSeries(Integer idSeries, SeriesDTO seriesDTO) {
        Series series = this.getSeriesById(idSeries);
        series.setSeries(seriesDTO.getSeries());
        return CreateSeriesDTO.createSeriesDTOFromSeries(this.seriesRepository.save(series));
    }

    @Override
    public SeriesDTO deleteSeries(Integer idSeries) {
        SeriesDTO seriesDTO = this.getSeriesDTOById(idSeries);
        try {
            seriesRepository.delete(this.getSeriesById(idSeries));
        } catch (DataIntegrityViolationException e){
            throw new CantDeleteException("Series can't be deleted...");
        }

        return seriesDTO;
    }
}

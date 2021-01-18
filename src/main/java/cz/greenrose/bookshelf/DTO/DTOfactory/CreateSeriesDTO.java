package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.models.Series;

public class CreateSeriesDTO {
    public static SeriesDTO createSeriesDTOFromSeries(Series series){

        SeriesDTO seriesDTO = new SeriesDTO(series.getId(),series.getSeries());

        return seriesDTO;
    }

}

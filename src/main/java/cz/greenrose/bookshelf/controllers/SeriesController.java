package cz.greenrose.bookshelf.controllers;
import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.models.Series;
import cz.greenrose.bookshelf.services.AuthorService;
import cz.greenrose.bookshelf.services.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeriesController {

    private SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/api/v1/series")
    public ResponseEntity<List<SeriesDTO>> getAllSeries(){
        return new ResponseEntity<>(this.seriesService.getAllSeries(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/series/{idSeries}")
    public ResponseEntity<SeriesDTO> getSeriesById(@PathVariable Integer idSeries){
        return new ResponseEntity<>(this.seriesService.getSeriesById(idSeries), HttpStatus.OK);
    }


}

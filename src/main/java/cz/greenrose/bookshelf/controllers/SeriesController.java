package cz.greenrose.bookshelf.controllers;
import cz.greenrose.bookshelf.models.Author;
import cz.greenrose.bookshelf.models.Series;
import cz.greenrose.bookshelf.services.AuthorService;
import cz.greenrose.bookshelf.services.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeriesController {

    private SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/api/v1/series")
    public ResponseEntity<List<Series>> getAllSeries(){
        return new ResponseEntity<>(this.seriesService.getAllSeries(), HttpStatus.OK);
    }

}

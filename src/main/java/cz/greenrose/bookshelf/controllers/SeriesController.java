package cz.greenrose.bookshelf.controllers;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.services.SeriesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeriesController {

    private SeriesService seriesService;

    public SeriesController(SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @GetMapping("/api/v1/series")
    public ResponseEntity<List<SeriesDTO>> getAllSeries(@RequestParam(required = false) Integer page){
        if (page == null) page = 0;
        return new ResponseEntity<>(this.seriesService.getAllSeries(page), HttpStatus.OK);
    }

    @GetMapping("/api/v1/series/{idSeries}")
    public ResponseEntity<SeriesDTO> getSeriesById(@PathVariable Integer idSeries){
        return new ResponseEntity<>(this.seriesService.getSeriesDTOById(idSeries), HttpStatus.OK);
    }

    @PostMapping("/api/v1/series")
    public ResponseEntity<SeriesDTO> postNewSeries( @RequestBody SeriesDTO series){
        return new ResponseEntity<>(this.seriesService.saveSeries(series), HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/v1/series/{idSeries}")
    public ResponseEntity<SeriesDTO> updateSeries(@PathVariable Integer idSeries, @RequestBody SeriesDTO series){
        return new ResponseEntity<>(this.seriesService.updateSeries(idSeries, series), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/v1/series/{idSeries}")
    public ResponseEntity<SeriesDTO> deleteSeries(@PathVariable Integer idSeries){
        return new ResponseEntity<>(this.seriesService.deleteSeries(idSeries), HttpStatus.ACCEPTED);
    }


}

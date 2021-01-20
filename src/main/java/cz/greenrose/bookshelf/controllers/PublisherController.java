package cz.greenrose.bookshelf.controllers;

import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.DTO.SeriesDTO;
import cz.greenrose.bookshelf.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/api/v1/publisher")
    public ResponseEntity<List<PublisherDTO>> getAllPublishers(){
        return new ResponseEntity<>(this.publisherService.getAllPublishers(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/publisher/{idPublisher}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Integer idPublisher){
        return new ResponseEntity<>(this.publisherService.getPublisherById(idPublisher), HttpStatus.OK);
    }

    @PostMapping("/api/v1/publisher")
    public ResponseEntity<PublisherDTO> postNewPublisher(@RequestBody PublisherDTO publisher){
        return new ResponseEntity<>(this.publisherService.savePublisher(publisher), HttpStatus.ACCEPTED);
    }

}

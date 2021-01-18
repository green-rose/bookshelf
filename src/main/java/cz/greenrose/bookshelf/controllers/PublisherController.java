package cz.greenrose.bookshelf.controllers;

import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

}

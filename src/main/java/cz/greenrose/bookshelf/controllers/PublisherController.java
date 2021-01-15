package cz.greenrose.bookshelf.controllers;
import cz.greenrose.bookshelf.models.Publisher;
import cz.greenrose.bookshelf.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/api/v1/publisher")
    public ResponseEntity<List<Publisher>> getAllPublishers(){
        return new ResponseEntity<>(this.publisherService.getAllPublishers(), HttpStatus.OK);
    }

}

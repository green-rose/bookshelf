package cz.greenrose.bookshelf.controllers;

import cz.greenrose.bookshelf.DTO.PublisherDTO;
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
    public ResponseEntity<List<PublisherDTO>> getAllPublishers(@RequestParam(required = false) Integer page){
        if (page == null) page = 0;
        return new ResponseEntity<>(this.publisherService.getAllPublishers(page), HttpStatus.OK);
    }

    @GetMapping("/api/v1/publisher/{idPublisher}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Integer idPublisher){
        return new ResponseEntity<>(this.publisherService.getPublisherDTOById(idPublisher), HttpStatus.OK);
    }

    @PostMapping("/api/v1/publisher")
    public ResponseEntity<PublisherDTO> postNewPublisher(@RequestBody PublisherDTO publisher){
        return new ResponseEntity<>(this.publisherService.savePublisher(publisher), HttpStatus.ACCEPTED);
    }

    @PutMapping("/api/v1/publisher/{idPublisher}")
    public ResponseEntity<PublisherDTO> updatePublisher(@PathVariable Integer idPublisher, @RequestBody PublisherDTO publisher){
        return new ResponseEntity<>(this.publisherService.updatePublisher(idPublisher, publisher), HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/api/v1/publisher/{idPublisher}")
    public ResponseEntity<PublisherDTO> deletePublisher(@PathVariable Integer idPublisher){
        return new ResponseEntity<>(this.publisherService.deletePublisher(idPublisher), HttpStatus.ACCEPTED);

    }
}

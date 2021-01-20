package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.models.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<PublisherDTO> getAllPublishers();

    PublisherDTO getPublisherById(Integer publisherId);

    PublisherDTO savePublisher(PublisherDTO publisher);

    Publisher findPublisher(PublisherDTO publisher);
}

package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.models.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<PublisherDTO> getAllPublishers(Integer page);

    PublisherDTO getPublisherDTOById(Integer publisherId);

    PublisherDTO savePublisher(PublisherDTO publisher);

    Publisher findPublisher(PublisherDTO publisher);

    PublisherDTO updatePublisher(Integer idPublisher, PublisherDTO publisher);

    PublisherDTO deletePublisher(Integer idPublisher);
}

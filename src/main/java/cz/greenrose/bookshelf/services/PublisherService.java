package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.PublisherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<PublisherDTO> getAllPublishers();

    PublisherDTO getPublisherById(Integer publisherId);
}

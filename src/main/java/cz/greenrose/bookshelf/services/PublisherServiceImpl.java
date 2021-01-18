package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.BookDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreateBookDTO;
import cz.greenrose.bookshelf.DTO.DTOfactory.CreatePublisherDTO;
import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.models.Book;
import cz.greenrose.bookshelf.models.Publisher;
import cz.greenrose.bookshelf.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

    private PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<PublisherDTO> getAllPublishers() {
        List<Publisher> publishers = this.publisherRepository.findAll();
        List<PublisherDTO> publisherDTO = new ArrayList<>();
        publishers.forEach(publisher -> publisherDTO.add(CreatePublisherDTO.createPublisherDTOFromPublisher(publisher)));
        return publisherDTO;
    }

    @Override
    public PublisherDTO getPublisherById(Integer publisherId) {
        Publisher publisher = this.publisherRepository.findById(publisherId).orElse(null);
        if (publisher == null) {
            throw new NoIDFoundException("Publisher id doesn't exist...");
        }
        return CreatePublisherDTO.createPublisherDTOFromPublisher(publisher);
    }
}

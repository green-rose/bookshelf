package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.DTOfactory.CreatePublisherDTO;
import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
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

    @Override
    public PublisherDTO savePublisher(PublisherDTO publisherDTO) {
        Publisher publisher = new Publisher();
        publisher.setPublisher(publisherDTO.getPublisher());
        if (this.publisherRepository.findFirstByPublisherEquals(publisherDTO.getPublisher()).orElse(null)!=null) {
            throw new DuplicateEntryException("Publisher already exists...");
        }
        Publisher newPubliser = this.publisherRepository.save(publisher);
        return CreatePublisherDTO.createPublisherDTOFromPublisher(newPubliser);
    }

    @Override
    public Publisher findPublisher(PublisherDTO publisherDTO) {
        if (this.publisherRepository.findFirstByPublisherEquals(publisherDTO.getPublisher()).orElse(null)!=null){
            return this.publisherRepository.findFirstByPublisherEquals(publisherDTO.getPublisher()).orElse(null);
        }
        Publisher publisher = new Publisher();
        publisher.setPublisher(publisherDTO.getPublisher());
        return this.publisherRepository.save(publisher);
    }
}

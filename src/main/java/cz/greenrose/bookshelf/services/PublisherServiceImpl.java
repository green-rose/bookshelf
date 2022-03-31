package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.DTO.DTOfactory.CreatePublisherDTO;
import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.exceptions.CantDeleteException;
import cz.greenrose.bookshelf.exceptions.DuplicateEntryException;
import cz.greenrose.bookshelf.exceptions.NoIDFoundException;
import cz.greenrose.bookshelf.models.Publisher;
import cz.greenrose.bookshelf.repositories.PublisherRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public List<PublisherDTO> getAllPublishers(Integer page) {
        Page<Publisher> publishers = this.publisherRepository.findAll(PageRequest.of(page, 10));
        List<PublisherDTO> publisherDTO = new ArrayList<>();
        publishers.forEach(publisher -> publisherDTO.add(CreatePublisherDTO.createPublisherDTOFromPublisher(publisher)));
        return publisherDTO;
    }

    public Publisher getPublisherById(Integer publisherId) {
        return this.publisherRepository.findById(publisherId).orElseThrow(()->new NoIDFoundException("Publisher id doesn't exist..."));
    }

    @Override
    public PublisherDTO getPublisherDTOById(Integer publisherId) {
        return CreatePublisherDTO.createPublisherDTOFromPublisher(this.getPublisherById(publisherId));
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

    @Override
    public PublisherDTO updatePublisher(Integer idPublisher, PublisherDTO publisherDTO) {
        Publisher publisher = this.getPublisherById(idPublisher);
        publisher.setPublisher(publisherDTO.getPublisher());
        return CreatePublisherDTO.createPublisherDTOFromPublisher(this.publisherRepository.save(publisher));
    }

    @Override
    public PublisherDTO deletePublisher(Integer idPublisher) {
        PublisherDTO publisherDTO = this.getPublisherDTOById(idPublisher);
        try {
            publisherRepository.delete(this.getPublisherById(idPublisher));
        } catch (DataIntegrityViolationException e){
            throw new CantDeleteException("Publisher can't be deleted...");
        }
        return publisherDTO;
    }
}

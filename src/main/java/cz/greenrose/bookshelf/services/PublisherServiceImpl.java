package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Publisher;
import cz.greenrose.bookshelf.models.Series;
import cz.greenrose.bookshelf.repositories.AuthorRepository;
import cz.greenrose.bookshelf.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService{

    private PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return this.publisherRepository.findAll();
    }
}

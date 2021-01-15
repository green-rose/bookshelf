package cz.greenrose.bookshelf.services;

import cz.greenrose.bookshelf.models.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PublisherService {
    List<Publisher> getAllPublishers();
}

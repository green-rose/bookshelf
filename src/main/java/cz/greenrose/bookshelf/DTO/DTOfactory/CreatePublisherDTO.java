package cz.greenrose.bookshelf.DTO.DTOfactory;

import cz.greenrose.bookshelf.DTO.PublisherDTO;
import cz.greenrose.bookshelf.models.Publisher;

import java.util.ArrayList;
import java.util.List;

public class CreatePublisherDTO {
    public static PublisherDTO createPublisherDTOFromPublisher(Publisher publisher){

        PublisherDTO publisherDTO = new PublisherDTO(publisher.getId(),publisher.getPublisher());

        return publisherDTO;
    }

}

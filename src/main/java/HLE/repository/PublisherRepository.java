package HLE.repository;

import HLE.entity.Author;
import HLE.entity.Publisher;

import java.util.List;

public interface PublisherRepository {
    String savePublisher(Publisher publisher);

    String getPublisherById(Long id);

    void getAllPublishers(List<Publisher> publishers);

   String updatePublisher(Long id,Publisher publisher);

   void deletePublisherByName(String name);
   String getPublisherByName(String name);
}

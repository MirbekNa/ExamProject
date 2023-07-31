package HLE.service.impl;

import HLE.entity.Publisher;
import HLE.repository.PublisherRepository;
import HLE.repository.impl.PublisherRepositoryImpl;
import HLE.service.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepository repository = new PublisherRepositoryImpl();

    @Override
    public String savePublisher(Publisher publisher) {
        return repository.savePublisher(publisher);
    }

    @Override
    public String getPublisherById(Long id) {
        return repository.getPublisherById(id);
    }

    @Override
    public void getAllPublishers(List<Publisher> publishers) {
        repository.getAllPublishers(publishers);
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        return repository.updatePublisher(id, publisher);
    }

    @Override
    public void deletePublisherByName(String name) {
        repository.deletePublisherByName(name);
    }

    @Override
    public String getPublisherByName(String name) {
        return repository.getPublisherByName(name);
    }
}

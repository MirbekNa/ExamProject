package HLE.service.impl;

import HLE.entity.Author;
import HLE.repository.AuthorRepository;
import HLE.repository.impl.AuthorRepositoryImpl;
import HLE.service.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepository repository = new AuthorRepositoryImpl();
    @Override
    public String saveAuthor(Author author) {
        return repository.saveAuthor(author);

    }
}

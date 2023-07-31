package HLE.repository.impl;

import HLE.Config.Configuration;
import HLE.entity.Author;
import HLE.repository.AuthorRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class AuthorRepositoryImpl implements AuthorRepository {

    private EntityManagerFactory entityManagerFactory = Configuration.getSessionFactory();

    @Override
    public String saveAuthor(Author author) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return "saved author with name:" + author.getFirstName();
    }
}



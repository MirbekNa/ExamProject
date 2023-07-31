package HLE.repository.impl;

import HLE.Config.Configuration;
import HLE.entity.Reader;
import HLE.repository.ReaderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class ReaderRepositoryImpl implements ReaderRepository {
    private EntityManagerFactory entityManagerFactory = Configuration.getSessionFactory();
    @Override
    public String saveReader(Reader reader){
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(reader);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "save reader with name"+reader.getName();
    }
    public List<Reader> getReadersByAuthorId(Long authorId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT r FROM Reader r JOIN r.book b JOIN b.authors a WHERE a.id = :authorId");
            query.setParameter("authorId", authorId);
            List<Reader> readers = query.getResultList();

            entityManager.getTransaction().commit();
            return readers;
        } finally {
            entityManager.close();
        }
    }
    public void deleteReaderById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Reader reader = entityManager.find(Reader.class, id);
            if (reader != null) {
                entityManager.remove(reader);
                entityManager.getTransaction().commit();
                System.out.println("Reader with id: " + id + " successfully deleted");
            } else {
                System.out.println("Reader with id: " + id + " not found");
            }
        } finally {
            entityManager.close();
        }
    }
    public Reader getReaderByBookId(Long bookId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Query query = entityManager.createQuery("SELECT r FROM Reader r WHERE r.book.id = :bookId");
            query.setParameter("bookId", bookId);
            Reader reader = (Reader) query.getSingleResult();

            entityManager.getTransaction().commit();
            return reader;
        } finally {
            entityManager.close();
        }
    }
    public void updateReader(Reader updatedReader) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            Reader reader = entityManager.find(Reader.class, updatedReader.getId());
            if (reader != null) {
                reader.setName(updatedReader.getName());
                reader.setAge(updatedReader.getAge());
                reader.setEmail(updatedReader.getEmail());
                reader.setBook(updatedReader.getBook());

                entityManager.getTransaction().commit();
                System.out.println("Reader with id: " + updatedReader.getId() + " successfully updated");
            } else {
                System.out.println("Reader with id: " + updatedReader.getId() + " not found");
            }
        } finally {
            entityManager.close();
        }
    }

}

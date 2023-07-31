package HLE.repository.impl;
import HLE.Config.Configuration;
import HLE.repository.BookRepository;
import jakarta.persistence.EntityManager;
import HLE.entity.Book;
import jakarta.persistence.EntityManagerFactory;


public class BookRepositoryImpl implements BookRepository {
private EntityManagerFactory entityManagerFactory= Configuration.getSessionFactory();

    @Override
    public String saveBook(Book book) {
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    return "saved book with name:"+book.getName();
    }
}

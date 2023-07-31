package HLE.repository.impl;

import HLE.Config.Configuration;
import HLE.entity.Publisher;
import HLE.repository.PublisherRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

import java.util.List;

public class PublisherRepositoryImpl implements PublisherRepository {
    private EntityManagerFactory entityManagerFactory = Configuration.getSessionFactory();

    @Override
    public String savePublisher(Publisher publisher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(publisher);
            entityManager.getTransaction().commit();
            System.out.println("Saved publisher: " + publisher.getName() + ", ID: " + publisher.getId() + ", Address: " + publisher.getAddress());
            return "Publisher saved successfully";
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String getPublisherById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Publisher publisher = entityManager.find(Publisher.class, id);
            entityManager.getTransaction().commit();

            if (publisher != null) {
                return " " + publisher;
            } else {
                return "Publisher with id: " + id + " not found";
            }
        } finally {
            entityManager.close();
        }
    }


    @Override
    public void getAllPublishers(List<Publisher> publishers) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();

            List<Publisher> publishersList = entityManager.createQuery("select p from Publisher p order by p.name").getResultList();
            entityManager.getTransaction().commit();

            for (Publisher publisher : publishersList) {
                System.out.println("Publisher Id: " + publisher.getId());
                System.out.println("Publisher Name: " + publisher.getName());
                System.out.println("Publisher Address: " + publisher.getAddress());
                System.out.println(); // Пустая строка для разделения информации об издателях
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String updatePublisher(Long id, Publisher publisher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Publisher p = entityManager.find(Publisher.class, id);
            if (p != null) {
                p.setBook(publisher.getBook());
                p.setName(publisher.getName());
                p.setBook(publisher.getBook());
              return "Publisher with id:"+id+"successful updated";
            } else {
                return "Publisher with id:" + id + "not found";
            }
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deletePublisherByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("select p from Publisher p where p.name = :name");
            query.setParameter("name", name);
            List<Publisher> publishers = query.getResultList();
            if (!publishers.isEmpty()) {
                for (Publisher publisher : publishers) {
                    entityManager.remove(publisher);
                    System.out.println("Publisher with name: " + name + " successfully deleted");
                }
            } else {
                System.out.println("Publisher with name: " + name + " not found");
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    @Override
    public String getPublisherByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
           Query publisher = entityManager.createQuery("select p from Publisher p where p.name = :name");
            entityManager.getTransaction().commit();
            if (publisher!=null) {
                return "Publisher"+publisher;
            } else {
                return "Publisher with name: " + name + " not found";
            }
        } finally {
            entityManager.close();
        }
    }


}

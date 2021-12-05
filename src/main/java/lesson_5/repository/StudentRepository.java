package lesson_5.repository;

import lesson_5.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private final EntityManagerFactory eMFactory;

    public StudentRepository(EntityManagerFactory eMFactory) {
        this.eMFactory = eMFactory;
    }

    public List<Student> findAll() {
        EntityManager em = eMFactory.createEntityManager();
        try {
            return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    public Optional<Student> findById(Long id) {
        EntityManager em = eMFactory.createEntityManager();
        try {
            return Optional.ofNullable(em.find(Student.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return Optional.empty();
    }

    public void delete(Student st) {
        EntityManager em = eMFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(st);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void insert(Student st) {
        EntityManager em = eMFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(st);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void update(Student st) {
        EntityManager em = eMFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(st);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}

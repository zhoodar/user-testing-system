package kg.djedai.app.storage;

import kg.djedai.app.models.Student;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class StudentStorage implements DAO<Student> {

    private final HibernateTransaction hibernateTransaction;

    public StudentStorage() {
        hibernateTransaction = new HibernateTransaction();
    }


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Student> getAll() {
        return this.hibernateTransaction.transaction((Session session)-> session.createQuery("from Student").list());
    }

    /**
     * Inserts the specified element to a store
     *
     * @param student adding object
     */
    public void create(Student student) {
        this.hibernateTransaction.transaction((Session session)-> {
            session.save(student); return null;
            }
        );
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Student read(int id) {
        return this.hibernateTransaction.transaction((Session session)->session.get(Student.class,id));
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param student element to be stored
     */
    public void update(Student student) {
        this.hibernateTransaction.transaction((Session session) -> {
            session.update(student);
            return null;
            }
        );
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param student element to be removed
     */
    public void delete(Student student) {
        this.hibernateTransaction.transaction((Session session)-> {
            session.delete(student);
            return null;
            }
        );
    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param name specified attribute
     * @return the element match
     */
    public Student findByName(String name) {
        return this.hibernateTransaction.transaction((Session session)->{
            final Query query = session.createQuery("from Student p where p.name=:name");
            query.setParameter("name",name);
            return (Student) query.list().iterator().next();
        });
    }

    /**
     * Closes the opened session
     */
    public void close() {
        this.hibernateTransaction.close();
    }
}

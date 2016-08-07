package kg.djedai.app.storage;

import kg.djedai.app.models.Teacher;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class TeacherStorage implements DAO<Teacher> {

    private final HibernateTransaction hibernateTransaction;

    public TeacherStorage() {
        hibernateTransaction = new HibernateTransaction();
    }


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Teacher> getAll() {
        return this.hibernateTransaction.transaction((Session session)-> session.createQuery("from Teacher").list());
    }

    /**
     * Inserts the specified element to a store
     *
     * @param teacher adding object
     */
    public void create(Teacher teacher) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.save(teacher); return null;
                }
        );
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Teacher read(int id) {
        return this.hibernateTransaction.transaction((Session session)->session.get(Teacher.class,id));
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param teacher element to be stored
     */
    public void update(Teacher teacher) {
        this.hibernateTransaction.transaction((Session session) -> {
                    session.update(teacher);
                    return null;
                }
        );
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param teacher element to be removed
     */
    public void delete(Teacher teacher) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.delete(teacher);
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
    public Teacher findByName(String name) {
        return this.hibernateTransaction.transaction((Session session)->{
            final Query query = session.createQuery("from Teacher t where t.name=:name");
            query.setParameter("name",name);
            return (Teacher) query.list().iterator().next();
        });
    }

    /**
     * Closes the opened session
     */
    public void close() {
        this.hibernateTransaction.close();
    }
}

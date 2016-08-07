package kg.djedai.app.storage;

import kg.djedai.app.models.Test;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class TestStorage implements DAO<Test> {

    private final HibernateTransaction hibernateTransaction;

    public TestStorage() {
        hibernateTransaction = new HibernateTransaction();
    }


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Test> getAll() {
        return this.hibernateTransaction.transaction((Session session)-> session.createQuery("from Test").list());
    }

    /**
     * Inserts the specified element to a store
     *
     * @param test adding object
     */
    public void create(Test test) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.save(test); return null;
                }
        );
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Test read(int id) {
        return this.hibernateTransaction.transaction((Session session)->session.get(Test.class,id));
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param test element to be stored
     */
    public void update(Test test) {
        this.hibernateTransaction.transaction((Session session) -> {
                    session.update(test);
                    return null;
                }
        );
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param test element to be removed
     */
    public void delete(Test test) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.delete(test);
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
    public Test findByName(String name) {
        return this.hibernateTransaction.transaction((Session session)->{
            final Query query = session.createQuery("from Test t where t.name=:name");
            query.setParameter("name",name);
            return (Test) query.list().iterator().next();
        });
    }

    /**
     * Closes the opened session
     */
    public void close() {
        this.hibernateTransaction.close();
    }
}

package kg.djedai.app.storage;

import kg.djedai.app.models.Group;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.hibernate.Session;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class GroupStorage implements DAO<Group> {

    private final HibernateTransaction hibernateTransaction;

    public GroupStorage() {
        hibernateTransaction = new HibernateTransaction();
    }
    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Group> getAll() {
        return this.hibernateTransaction.transaction((Session session)-> session.createQuery("from Group ").list());
    }

    /**
     * Inserts the specified element to a store
     *
     * @param group adding object
     */
    public void create(Group group) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.save(group); return null;
                }
        );
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Group read(int id) {
        return this.hibernateTransaction.transaction((Session session)->session.get(Group.class,id));
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param group element to be stored
     */
    public void update(Group group) {
        this.hibernateTransaction.transaction((Session session) -> {
                    session.update(group);
                    return null;
                }
        );
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param group element to be removed
     */
    public void delete(Group group) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.delete(group);
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
    public Group findByName(String name) {
        return null;
    }

    /**
     * Closes the opened session
     */
    public void close() {
        this.hibernateTransaction.close();
    }
}

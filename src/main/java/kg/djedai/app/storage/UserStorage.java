package kg.djedai.app.storage;

import kg.djedai.app.models.User;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class UserStorage implements DAO<User> {

    private final HibernateTransaction hibernateTransaction;

    public UserStorage() {
        hibernateTransaction = new HibernateTransaction();
    }


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<User> getAll() {
        return this.hibernateTransaction.transaction((Session session)-> session.createQuery("from User").list());
    }

    /**
     * Inserts the specified element to a store
     *
     * @param user adding object
     */
    public void create(User user) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.save(user); return null;
                }
        );
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public User read(int id) {
        return this.hibernateTransaction.transaction((Session session)->session.get(User.class,id));
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param user element to be stored
     */
    public void update(User user) {
        this.hibernateTransaction.transaction((Session session) -> {
                    session.update(user);
                    return null;
                }
        );
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param user element to be removed
     */
    public void delete(User user) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.delete(user);
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
    public User findByName(String name) {
        return this.hibernateTransaction.transaction((Session session)->{
            final Query query = session.createQuery("from User u where u.login=:name");
            query.setParameter("name",name);
            return (User) query.list().iterator().next();
        });
    }

    /**
     * Closes the opened session
     */
    public void close() {
        this.hibernateTransaction.close();
    }
}

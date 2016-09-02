package kg.djedai.app.storage;

import kg.djedai.app.models.User;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */

@Repository
@Transactional
public class UserStorage  extends HibernateTransaction implements DAO<User> {


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<User> getAll() {
        return getCurrentSession().createQuery("from User").list();
    }

    /**
     * Inserts the specified element to a store
     *
     * @param user adding object
     */
    public void create(User user) {
       getCurrentSession().save(user);
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public User read(int id) {
        return getCurrentSession().get(User.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param user element to be stored
     */
    public void update(User user) {
        getCurrentSession().update(user);

    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param user element to be removed
     */
    public void delete(User user) {
        getCurrentSession().delete(user);
    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param login
     * @param password specified attribute
     * @return the element match
     */
    public User findByToSearch(String login, String password) {
        List list =  getCurrentSession().createQuery("from User u where u.login=:login and u.password=:password")
                .setParameter("login", login)
                .setParameter("password",password).list();
        if(!list.isEmpty())
            return (User)list.iterator().next();
        return null;
    }

    /**
     * Closes the opened session
     */
    public void close() {
    }

    /**
     * Returns list of the elements where param id equals element id
     *
     * @param id element id
     * @return list of elements
     */
    public List getByIdOfInnerElement(int id) {
        return null;
    }
}

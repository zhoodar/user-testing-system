package kg.djedai.app.storage;

import kg.djedai.app.models.Group;
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
public class GroupStorage extends HibernateTransaction implements DAO<Group> {

    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Group> getAll() {
        return getCurrentSession().createQuery("from Group ").list();
    }

    /**
     * Inserts the specified element to a store
     *
     * @param group adding object
     */
    public void create(Group group) {
          getCurrentSession().save(group);
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Group read(int id) {
        return getCurrentSession().get(Group.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param group element to be stored
     */
    public void update(Group group) {
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param group element to be removed
     */
    public void delete(Group group) {
    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch specified attribute
     * @param secondToSearch
     * @return the element match
     */
    public Group findByToSearch(String toSearch, String secondToSearch) {
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

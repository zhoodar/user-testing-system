package kg.djedai.app.storage;

import kg.djedai.app.models.GuestUser;
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
public class GuestUserStorage implements DAO<GuestUser> {


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<GuestUser> getAll() {
        return null;
    }

    /**
     * Inserts the specified element to a store
     *
     * @param o adding object
     */
    public void create(GuestUser o) {

    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public GuestUser read(int id) {
        return null;
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param o element to be stored
     */
    public void update(GuestUser o) {

    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param o element to be removed
     */
    public void delete(GuestUser o) {

    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch specified attribute
     * @param secondToSearch
     * @return the element match
     */
    public GuestUser findByToSearch(String toSearch, String secondToSearch) {
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

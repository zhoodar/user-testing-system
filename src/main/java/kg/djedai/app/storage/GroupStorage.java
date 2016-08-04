package kg.djedai.app.storage;

import kg.djedai.app.models.Group;
import kg.djedai.app.storage.dao.DAO;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class GroupStorage implements DAO<Group> {
    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Group> getAll() {
        return null;
    }

    /**
     * Inserts the specified element to a store
     *
     * @param o adding object
     */
    public void create(Group o) {

    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Group read(int id) {
        return null;
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param o element to be stored
     */
    public void update(Group o) {

    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param o element to be removed
     */
    public void delete(Group o) {

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

    }
}

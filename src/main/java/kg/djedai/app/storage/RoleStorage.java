package kg.djedai.app.storage;

import kg.djedai.app.models.Role;
import kg.djedai.app.storage.dao.DAO;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class RoleStorage implements DAO<Role> {
    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Role> getAll() {
        return null;
    }

    /**
     * Inserts the specified element to a store
     *
     * @param o adding object
     */
    public void create(Role o) {

    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Role read(int id) {
        return null;
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param o element to be stored
     */
    public void update(Role o) {

    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param o element to be removed
     */
    public void delete(Role o) {

    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param name specified attribute
     * @return the element match
     */
    public Role findByName(String name) {
        return null;
    }

    /**
     * Closes the opened session
     */
    public void close() {

    }
}

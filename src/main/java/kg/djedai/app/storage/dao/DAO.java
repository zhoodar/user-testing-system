package kg.djedai.app.storage.dao;

import java.util.Collection;

/**
 * The interface provides basic implementation of the CRUD operations
 * @author Zhoodar
 * @since 29.07.2016.
 */
public interface DAO<T> {

    /**
     * Returns the Collection of elements in a store
     * @return collection of elements
     */
    Collection<T> getAll();

    /**
     * Inserts the specified element to a store
     * @param o adding object
     */
    void create(T o);

    /**
     * Returns the element at the specified position in a store.
     * @param id specified position
     * @return element at the specified position
     */
    T read(int id);

    /**
     * Replaces the first occurrence of the specified element in store
     * @param o element to be stored
     */
    void update(T o);

    /**
     * Removes the first occurrence of the specified element from store
     * @param o element to be removed
     */
    void delete(T o);

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     * @param name specified attribute
     * @return the element match
     */
    T findByName(String name);

    /**
     * Closes the opened session
     */
    void close();
}


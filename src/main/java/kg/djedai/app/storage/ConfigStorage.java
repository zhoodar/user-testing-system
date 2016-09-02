package kg.djedai.app.storage;

import kg.djedai.app.models.TestConfig;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author Zhoodar
 * @since 20.08.2016.
 */
@Repository
@Transactional
public class ConfigStorage extends HibernateTransaction implements DAO<TestConfig> {

    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    @Override
    public Collection<TestConfig> getAll() {
        return null;
    }

    /**
     * Inserts the specified element to a store
     *
     * @param config adding object
     */
    @Override
    public void create(TestConfig config) {
        getCurrentSession().save(config);
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    @Override
    public TestConfig read(int id) {
        return getCurrentSession().get(TestConfig.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param config element to be stored
     */
    @Override
    public void update(TestConfig config) {
        getCurrentSession().update(config);
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param o element to be removed
     */
    @Override
    public void delete(TestConfig o) {

    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch       specified attribute
     * @param secondToSearch
     * @return the element match
     */
    @Override
    public TestConfig findByToSearch(String toSearch, String secondToSearch) {
        return null;
    }

    /**
     * Closes the opened session
     */
    @Override
    public void close() {

    }

    /**
     * Returns list of the elements where param id equals element id
     *
     * @param id element id
     * @return list of elements
     */
    @Override
    public List getByIdOfInnerElement(int id) {
        return null;
    }
}

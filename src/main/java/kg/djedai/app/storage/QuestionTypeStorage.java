package kg.djedai.app.storage;

import kg.djedai.app.models.Question;
import kg.djedai.app.models.QuestionType;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * @author Zhoodar
 * @since 22.08.2016.
 */
@Repository
@Transactional
public class QuestionTypeStorage extends HibernateTransaction implements DAO<QuestionType> {
    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    @Override
    public Collection<QuestionType> getAll() {
        return null;
    }

    /**
     * Inserts the specified element to a store
     *
     * @param o adding object
     */
    @Override
    public void create(QuestionType o) {

    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    @Override
    public QuestionType read(int id) {
        return getCurrentSession().get(QuestionType.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param o element to be stored
     */
    @Override
    public void update(QuestionType o) {

    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param o element to be removed
     */
    @Override
    public void delete(QuestionType o) {

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
    public QuestionType findByToSearch(String toSearch, String secondToSearch) {
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

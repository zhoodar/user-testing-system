package kg.djedai.app.storage;

import kg.djedai.app.models.Answer;
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
public class AnswerStorage extends HibernateTransaction implements DAO<Answer> {


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Answer> getAll() {
        return getCurrentSession().createQuery("from Answer ").list();
    }

    /**
     * Inserts the specified element to a store
     *
     * @param answer adding object
     */
    public void create(Answer answer) {
        getCurrentSession().save(answer);

    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Answer read(int id) {
        return getCurrentSession().get(Answer.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param answer element to be stored
     */
    public void update(Answer answer) {
        getCurrentSession().update(answer);
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param answer element to be removed
     */
    public void delete(Answer answer) {
        getCurrentSession().delete(answer);

    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch specified attribute
     * @param secondToSearch
     * @return the element match
     */
    public Answer findByToSearch(String toSearch, String secondToSearch) {
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

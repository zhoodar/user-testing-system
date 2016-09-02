package kg.djedai.app.storage;

import kg.djedai.app.models.Question;
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
public class QuestionStorage extends HibernateTransaction implements DAO<Question> {


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Question> getAll() {
        return getCurrentSession().createQuery("from Question").list();
    }

    /**
     * Inserts the specified element to a store
     *
     * @param question adding object
     */
    public void create(Question question) {
       getCurrentSession().save(question);
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Question read(int id) {
        return null;
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param question element to be stored
     */
    public void update(Question question) {

    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param question element to be removed
     */
    public void delete(Question question) {

    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch specified attribute
     * @param secondToSearch
     * @return the element match
     */
    public Question findByToSearch(String toSearch, String secondToSearch) {
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
        return  getCurrentSession().createQuery("from Question q where q.test.id=:id").setParameter("id", id).list();
    }
}

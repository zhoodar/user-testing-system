package kg.djedai.app.storage;

import kg.djedai.app.models.Student;
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
public class StudentStorage extends HibernateTransaction implements DAO<Student> {


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Student> getAll() {
        return getCurrentSession().createQuery("from Student").list();
    }

    /**
     * Inserts the specified element to a store
     *
     * @param student adding object
     */
    public void create(Student student) {

    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Student read(int id) {
        return getCurrentSession().get(Student.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param student element to be stored
     */
    public void update(Student student) {
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param student element to be removed
     */
    public void delete(Student student) {
    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch specified attribute
     * @param secondToSearch
     * @return the element match
     */
    public Student findByToSearch(String toSearch, String secondToSearch) {
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

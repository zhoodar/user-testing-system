package kg.djedai.app.storage;

import kg.djedai.app.models.Teacher;
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
public class TeacherStorage  extends HibernateTransaction implements DAO<Teacher> {


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Teacher> getAll() {
        return getCurrentSession().createQuery("from Teacher").list();
    }

    /**
     * Inserts the specified element to a store
     *
     * @param teacher adding object
     */
    public void create(Teacher teacher) {
        getCurrentSession().save(teacher);

    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Teacher read(int id) {
        return getCurrentSession().get(Teacher.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param teacher element to be stored
     */
    public void update(Teacher teacher) {
        getCurrentSession().update(teacher);

    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param teacher element to be removed
     */
    public void delete(Teacher teacher) {
        getCurrentSession().delete(teacher);

    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch specified attribute
     * @param secondToSearch
     * @return the element match
     */
    public Teacher findByToSearch(String toSearch, String secondToSearch) {
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
        return getCurrentSession().createQuery("from Teacher t where t.id=:id").setParameter("id", id).list();
    }

}

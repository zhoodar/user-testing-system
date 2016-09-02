package kg.djedai.app.storage;

import kg.djedai.app.models.Test;
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
public class TestStorage extends HibernateTransaction implements DAO<Test> {


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Test> getAll() {
        return (Collection<Test>) getCurrentSession().createQuery("from Test").list();
    }

    /**
     * Inserts the specified element to a store
     *
     * @param test adding object
     */
    public void create(Test test) {
            getCurrentSession().save(test);
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Test read(int id) {
        return getCurrentSession().get(Test.class,id);
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param test element to be stored
     */
    public void update(Test test) {
        getCurrentSession().update(test);
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param test element to be removed
     */
    public void delete(Test test) {
        getCurrentSession().delete(test);
    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param toSearch specified attribute
     * @param secondToSearch
     * @return the element match
     */
    public Test findByToSearch(String toSearch, String secondToSearch) {
        /*return this.hibernateTransaction.transaction((Session session)->{
            final Query query = session.createQuery("from Test t where t.name=:name");
            query.setParameter("name",name);
            return (Test) query.list().iterator().next();
        });*/ return null;
    }

    /**
     * Closes the opened session
     */
    public void close() {
        //this.hibernateTransaction.close();
    }

    /**
     * Returns list of the elements where param id equals element id
     *
     * @param id element id
     * @return list of elements
     */
    public List getByIdOfInnerElement(int id) {
        return getCurrentSession().createQuery("from Test t where t.teacher.id=:id").setParameter("id",id).list();
    }
}

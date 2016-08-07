package kg.djedai.app.storage;

import kg.djedai.app.models.Answer;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class AnswerStorage implements DAO<Answer> {


    private final HibernateTransaction hibernateTransaction;

    public AnswerStorage() {
        hibernateTransaction = new HibernateTransaction();
    }


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Answer> getAll() {
        return this.hibernateTransaction.transaction((Session session)-> session.createQuery("from Answer ").list());
    }

    /**
     * Inserts the specified element to a store
     *
     * @param answer adding object
     */
    public void create(Answer answer) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.save(answer); return null;
                }
        );
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Answer read(int id) {
        return this.hibernateTransaction.transaction((Session session)->session.get(Answer.class,id));
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param answer element to be stored
     */
    public void update(Answer answer) {
        this.hibernateTransaction.transaction((Session session) -> {
                    session.update(answer);
                    return null;
                }
        );
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param answer element to be removed
     */
    public void delete(Answer answer) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.delete(answer);
                    return null;
                }
        );
    }

    /**
     * Returns the first occurrence of the specified element if the element name's
     * equals with the specified attribute
     *
     * @param name specified attribute
     * @return the element match
     */
    public Answer findByName(String name) {
        return this.hibernateTransaction.transaction((Session session)->{
            final Query query = session.createQuery("from Answer a where a.text=:name");
            query.setParameter("name",name);
            return (Answer) query.list().iterator().next();
        });
    }

    /**
     * Closes the opened session
     */
    public void close() {
        this.hibernateTransaction.close();
    }
}

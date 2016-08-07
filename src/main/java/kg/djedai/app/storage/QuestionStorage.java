package kg.djedai.app.storage;

import kg.djedai.app.models.Question;
import kg.djedai.app.service.HibernateTransaction;
import kg.djedai.app.storage.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Collection;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class QuestionStorage implements DAO<Question> {

    private final HibernateTransaction hibernateTransaction;

    public QuestionStorage() {
        hibernateTransaction = new HibernateTransaction();
    }


    /**
     * Returns the Collection of elements in a store
     *
     * @return collection of elements
     */
    public Collection<Question> getAll() {
        return this.hibernateTransaction.transaction((Session session)-> session.createQuery("from Question").list());
    }

    /**
     * Inserts the specified element to a store
     *
     * @param question adding object
     */
    public void create(Question question) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.save(question); return null;
                }
        );
    }

    /**
     * Returns the element at the specified position in a store.
     *
     * @param id specified position
     * @return element at the specified position
     */
    public Question read(int id) {
        return this.hibernateTransaction.transaction((Session session)->session.get(Question.class,id));
    }

    /**
     * Replaces the first occurrence of the specified element in store
     *
     * @param question element to be stored
     */
    public void update(Question question) {
        this.hibernateTransaction.transaction((Session session) -> {
                    session.update(question);
                    return null;
                }
        );
    }

    /**
     * Removes the first occurrence of the specified element from store
     *
     * @param question element to be removed
     */
    public void delete(Question question) {
        this.hibernateTransaction.transaction((Session session)-> {
                    session.delete(question);
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
    public Question findByName(String name) {
        return this.hibernateTransaction.transaction((Session session)->{
            final Query query = session.createQuery("from Question q where q.text=:name");
            query.setParameter("name",name);
            return (Question) query.list().iterator().next();
        });
    }

    /**
     * Closes the opened session
     */
    public void close() {
        this.hibernateTransaction.close();
    }
}

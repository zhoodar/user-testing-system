package kg.djedai.app.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * @author Zhoodar
 * @since 05.08.2016.
 */
public class HibernateTransaction {

    private final SessionFactory sessionFactory;

    public HibernateTransaction() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public interface Command<E>{
        E process(Session session);
    }

    public <E> E transaction(final Command<E> command){
        final Session session = sessionFactory.openSession();
        final Transaction tn = session.beginTransaction();
        try{
            return command.process(session);
        } finally {
            tn.commit();
            session.close();
        }
    }

    public void close(){
        this.sessionFactory.close();
    }

}

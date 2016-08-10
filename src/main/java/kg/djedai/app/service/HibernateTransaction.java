package kg.djedai.app.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhoodar
 * @since 05.08.2016.
 */
@Service
public abstract class HibernateTransaction {

    @Autowired
    private SessionFactory  sessionFactory;

    protected Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }
}

package Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class DBConnector {

    public static Configuration configuration;
    public static SessionFactory sessionFactory;
    public static Session session;
    public static Transaction transaction;

    public static void connection() {
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static void save(Object entity) {
        transAction();
        session.save(entity);
        commit();
    }
    public static void update(Object entity) {
        transAction();
        session.update(entity);
        commit();
    }

    public static void transAction(){
        transaction = session.beginTransaction();
    }

    public static void commit() {
        transaction.commit();
    }

    public static void disConnection() {
        session.close();
        sessionFactory.close();
    }

    public static List query(String loadQuery) {
        transAction();
        List query = session.createQuery(loadQuery).list();
        commit();
        return query;
    }
}

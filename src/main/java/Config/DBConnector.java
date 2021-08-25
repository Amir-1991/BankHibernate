package Config;

import Entity.CustomerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class DBConnector {

    public static Configuration configuration;
    public static SessionFactory sessionFactory;
    public static Session session;
    public static Transaction transaction;
    public static Query query;

    public static void connection(){
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public static void save(Object entity){
        transaction = session.beginTransaction();
        session.save(entity);
    }

    public static void commit(){
        transaction.commit();
    }

    public static void disConnection(){
        session.close();
        sessionFactory.close();
    }

    public static List query(String loadQuery){
        transaction = session.beginTransaction();
        query = session.createQuery(loadQuery);
        List<CustomerEntity> reList = query.getResultList();
        return reList;
    }
}

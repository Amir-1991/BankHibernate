package Config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.text.html.parser.Entity;

public class DBConnector {

    public static Configuration configuration;
    public static SessionFactory sessionFactory;
    public static Session session;
    public static Transaction transaction;

    public static void connection(){
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    public static void save(Entity entity){
        session.save(entity);
    }

    public static void commit(){
        transaction.commit();
    }

    public static void disConnection(){
        session.close();
        sessionFactory.close();
    }
}

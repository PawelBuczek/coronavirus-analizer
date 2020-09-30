package pl.sdacademy.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import pl.sdacademy.coronavirus.SessionFactoryProvider;
import pl.sdacademy.credentials.User;

import java.util.List;

public class Main {
    public static SessionFactory sessionFactory;


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        readData(sessionFactory);






        sessionFactory.close();

    }


    public static void readData(SessionFactory sessionFactory) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Weather> query = session.createQuery("FROM Weather ", Weather.class);
        List<Weather> result = query.getResultList();
        System.out.println(result);
        transaction.commit();
        session.close();
    }



}

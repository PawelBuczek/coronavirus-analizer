package pl.sdacademy.weather;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static SessionFactory sessionFactory;


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernateWeather.cfg.xml")
                .buildSessionFactory();
        readData(sessionFactory);
        System.out.println(readDataModified(sessionFactory));

        sessionFactory.close();

    }


    public static void readData(SessionFactory sessionFactory) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Weather> query = session.createQuery("SELECT w FROM Weather w" );
        List<Weather> result = query.getResultList();
        System.out.println(result);
        transaction.commit();
        session.close();

    }
    public static List<Weather> readDataModified(SessionFactory sessionFactory) {

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Weather> query = session.createQuery("SELECT w FROM Weather w ");
        List<Weather> result = query.getResultList();
        transaction.commit();
        session.close();
        return result;



    }




}

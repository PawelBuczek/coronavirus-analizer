package pl.sdacademy.coronavirus;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SessionFactoryProvider {
    public static void main(String[] args) {
        SessionFactory sessionFactory =  new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Country country = new Country("Poland", "PL", 38_000_000L);
        session.save(country);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}


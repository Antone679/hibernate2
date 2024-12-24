package config;

import entity.City;
import entity.Country;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Country.class);
            configuration.addAnnotatedClass(City.class);
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception ex) {
            System.out.println("Ошибка инициализации подключения к базе данных.");
            ex.printStackTrace();
        }
    }

    private HibernateConfig() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}

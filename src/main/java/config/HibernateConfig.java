package config;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration()
                    .addAnnotatedClass(Actor.class)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(City.class)
                    .addAnnotatedClass(Country.class)
                    .addAnnotatedClass(Customer.class)
                    .addAnnotatedClass(Film.class)
                    .addAnnotatedClass(FilmActor.class)
                    .addAnnotatedClass(FilmCategory.class)
                    .addAnnotatedClass(FilmText.class)
                    .addAnnotatedClass(Inventory.class)
                    .addAnnotatedClass(Language.class)
                    .addAnnotatedClass(Payment.class)
                    .addAnnotatedClass(Rental.class)
                    .addAnnotatedClass(SpecialFeature.class)
                    .addAnnotatedClass(Staff.class)
                    .addAnnotatedClass(Store.class);

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

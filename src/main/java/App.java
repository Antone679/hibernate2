import config.HibernateConfig;
import entity.City;
import entity.Country;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class App {
    public static void main(String[] args) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();

            Country country  = new Country();
            country.setName("Биби");
            City city = new City();
            city.setCountry(country);
            city.setName("Вларка");
            country.setCities(List.of(city));
            session.persist(country);
            transaction.commit();
        }
    }
}

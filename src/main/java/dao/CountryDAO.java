package dao;

import entity.City;
import entity.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends AbstractDAO<Country> {
    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}

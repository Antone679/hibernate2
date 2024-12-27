package dao;

import entity.Address;
import org.hibernate.SessionFactory;

public class AddressDAO extends AbstractDAO<Address> {
    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}

package dao;

import entity.City;
import entity.Staff;
import org.hibernate.SessionFactory;

public class StaffDAO extends AbstractDAO<Staff> {
    public StaffDAO(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}

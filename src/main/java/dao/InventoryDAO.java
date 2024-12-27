package dao;

import config.HibernateConfig;
import entity.City;
import entity.Inventory;
import entity.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class InventoryDAO extends AbstractDAO<Inventory> {
    public InventoryDAO(SessionFactory sessionFactory) {
        super(Inventory.class, sessionFactory);
    }

}

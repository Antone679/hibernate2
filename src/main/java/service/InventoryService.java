package service;

import config.HibernateConfig;
import dao.*;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryService {
    private SessionFactory sessionFactory;
    private InventoryDAO inventoryDAO;
    private RentalDAO rentalDAO;
    private StoreDAO storeDAO;
    private FilmDAO filmDAO;
    private PaymentDAO paymentDAO;
    private CustomerDAO customerDAO;

    public InventoryService(SessionFactory sessionFactory, InventoryDAO inventoryDAO, RentalDAO rentalDAO, StoreDAO storeDAO,
                            FilmDAO filmDAO, PaymentDAO paymentDAO, CustomerDAO customerDAO) {
        this.sessionFactory = sessionFactory;
        this.inventoryDAO = inventoryDAO;
        this.rentalDAO = rentalDAO;
        this.storeDAO = storeDAO;
        this.filmDAO = filmDAO;
        this.paymentDAO = paymentDAO;
        this.customerDAO = customerDAO;
    }

    public void customerMakesRental() {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Customer customer = customerDAO.getById(15);
            Film film = filmDAO.getAvailableFilmForRent();
            Store store = storeDAO.getById(1);
            Staff staff = store.getStaff();

            Inventory inventory = new Inventory();
            inventory.setFilm(film);
            inventory.setStore(store);
            inventoryDAO.save(inventory);
            System.out.println(inventory.getId());

            Rental rental = new Rental();
            rental.setRentalDate(LocalDateTime.now());
            rental.setInventory(inventory);
            rental.setCustomer(customer);
            rental.setStaff(staff);
            rentalDAO.save(rental);
            System.out.println(rental.getId());

            Payment payment = new Payment();
            payment.setCustomer(customer);
            payment.setStaff(staff);
            payment.setRental(rental);
            payment.setPaymentDate(LocalDateTime.now());
            payment.setAmount(BigDecimal.valueOf(3.00));
            paymentDAO.save(payment);
            System.out.println(payment.getId());

            transaction.commit();
            System.out.println("Rental created successfully.");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }


    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public InventoryDAO getInventoryDAO() {
        return inventoryDAO;
    }

    public void setInventoryDAO(InventoryDAO inventoryDAO) {
        this.inventoryDAO = inventoryDAO;
    }

    public RentalDAO getRentalDAO() {
        return rentalDAO;
    }

    public void setRentalDAO(RentalDAO rentalDAO) {
        this.rentalDAO = rentalDAO;
    }

    public StoreDAO getStoreDAO() {
        return storeDAO;
    }

    public void setStoreDAO(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public FilmDAO getFilmDAO() {
        return filmDAO;
    }

    public void setFilmDAO(FilmDAO filmDAO) {
        this.filmDAO = filmDAO;
    }

    public PaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public void setPaymentDAO(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}

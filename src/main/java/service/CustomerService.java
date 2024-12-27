package service;

import config.HibernateConfig;
import dao.AddressDAO;
import dao.CityDAO;
import dao.CustomerDAO;
import dao.StoreDAO;
import entity.Address;
import entity.City;
import entity.Customer;
import entity.Store;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class CustomerService {
    private SessionFactory sessionFactory;
    private CustomerDAO customerDAO;
    private AddressDAO addressDAO;
    private StoreDAO storeDAO;
    private CityDAO cityDAO;

    public CustomerService(SessionFactory sessionFactory, CustomerDAO customerDAO, AddressDAO addressDAO, StoreDAO storeDAO, CityDAO cityDAO) {
        this.sessionFactory = sessionFactory;
        this.customerDAO = customerDAO;
        this.addressDAO = addressDAO;
        this.storeDAO = storeDAO;
        this.cityDAO = cityDAO;
    }

    public Customer createCustomer() {
        Session session = null;
        Transaction transaction = null;
        Customer customer = null;
        try{
        session = sessionFactory.getCurrentSession();
        transaction = session.beginTransaction();

        City city = cityDAO.getById(88);
        Store store = storeDAO.getById(2);

        Address address = new Address();
        address.setPrimaryAddress("15 St. George W.");
        address.setSecondaryAddress("15 St. George W./2");
        address.setDistrict("Oak ford");
        address.setCity(city);
        address.setPostalCode("555-666");
        address.setPhoneNumber("+1-212-458-90-43");
        addressDAO.save(address);

        customer = new Customer();
        customer.setStore(store);
        customer.setFirstName("Ivan");
        customer.setLastName("Travis");
        customer.setEmail("ivanTravis679@gmail.com");
        customer.setAddress(address);
        customer.setActive(true);
        customer.setCreateDate(new Date());
        customerDAO.save(customer);

        transaction.commit();

        } catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        } finally {
            if (session != null && session.isOpen()){
                session.close();
            }
        }
        return customer;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public AddressDAO getAddressDAO() {
        return addressDAO;
    }

    public void setAddressDAO(AddressDAO addressDAO) {
        this.addressDAO = addressDAO;
    }

    public StoreDAO getStoreDAO() {
        return storeDAO;
    }

    public void setStoreDAO(StoreDAO storeDAO) {
        this.storeDAO = storeDAO;
    }

    public CityDAO getCityDAO() {
        return cityDAO;
    }

    public void setCityDAO(CityDAO cityDAO) {
        this.cityDAO = cityDAO;
    }
}

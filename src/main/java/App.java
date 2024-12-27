
import config.HibernateConfig;
import dao.*;
import entity.Customer;
import org.hibernate.SessionFactory;
import service.CustomerService;
import service.FilmService;
import service.InventoryService;
import service.RentalService;

public class App {

    private  ActorDAO actorDAO;
    private  AddressDAO addressDAO;
    private  CategoryDAO categoryDAO;
    private  CityDAO cityDAO;
    private  CountryDAO countryDAO;
    private  CustomerDAO customerDAO;
    private  FilmDAO filmDAO;
    private  FilmTextDAO filmTextDAO;
    private  InventoryDAO inventoryDAO;
    private  LanguageDAO languageDAO;
    private  PaymentDAO paymentDAO;
    private  RentalDAO rentalDAO;
    private  StaffDAO staffDAO;
    private  StoreDAO storeDAO;
    private  CustomerService customerService;
    private  RentalService rentalService;
    private  InventoryService inventoryService;
    private  SessionFactory sessionFactory;
    private  FilmService filmService;

    public App() {
        sessionFactory = HibernateConfig.getSessionFactory();

        actorDAO = new ActorDAO(sessionFactory);
        addressDAO = new AddressDAO(sessionFactory);
        categoryDAO = new CategoryDAO(sessionFactory);
        cityDAO = new CityDAO(sessionFactory);
        countryDAO = new CountryDAO(sessionFactory);
        customerDAO = new CustomerDAO(sessionFactory);
        filmDAO = new FilmDAO(sessionFactory);
        filmTextDAO = new FilmTextDAO(sessionFactory);
        inventoryDAO = new InventoryDAO(sessionFactory);
        paymentDAO = new PaymentDAO(sessionFactory);
        rentalDAO = new RentalDAO(sessionFactory);
        staffDAO = new StaffDAO(sessionFactory);
        storeDAO = new StoreDAO(sessionFactory);
        languageDAO = new LanguageDAO(sessionFactory);
        customerService = new CustomerService(sessionFactory, customerDAO, addressDAO,
                storeDAO, cityDAO);
        inventoryService = new InventoryService(sessionFactory, inventoryDAO, rentalDAO, storeDAO,
                filmDAO, paymentDAO, customerDAO);
        rentalService = new RentalService(sessionFactory, rentalDAO);
        filmService = new FilmService(filmDAO, actorDAO, languageDAO, sessionFactory, categoryDAO);
    }

    public static void main(String[] args) {
        App app = new App();
        app.customerService.createCustomer();
        app.rentalService.returnRental();
        app.inventoryService.customerMakesRental();
        app.filmService.newFilmAvailable();

    }


}

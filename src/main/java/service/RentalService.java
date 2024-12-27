package service;

import config.HibernateConfig;
import dao.RentalDAO;
import entity.Rental;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.time.LocalDateTime;

public class RentalService {
    private SessionFactory sessionFactory;
    private RentalDAO rentalDAO;

    public RentalService(SessionFactory sessionFactory, RentalDAO rentalDAO) {
        this.sessionFactory = sessionFactory;
        this.rentalDAO = rentalDAO;
    }

    public void returnRental(){
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            Rental rental = rentalDAO.getRandomUnreturnedRental();
            rental.setReturnDate(LocalDateTime.now());

            rentalDAO.update(rental);
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
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public RentalDAO getRentalDAO() {
        return rentalDAO;
    }

    public void setRentalDAO(RentalDAO rentalDAO) {
        this.rentalDAO = rentalDAO;
    }
}

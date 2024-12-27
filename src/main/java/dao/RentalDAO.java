package dao;


import entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.time.LocalDateTime;


public class RentalDAO extends AbstractDAO<Rental> {
    public RentalDAO(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getRandomUnreturnedRental(){
        Query<Rental> query = getSession().createQuery("SELECT r FROM Rental r where r.returnDate < :req_date",
                Rental.class);
        query.setParameter("req_date", LocalDateTime.of(2006, 5, 29, 20, 15));
                query.setMaxResults(1);

                return query.getSingleResult();

    }
}

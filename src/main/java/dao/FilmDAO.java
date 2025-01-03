package dao;

import entity.Film;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class FilmDAO extends AbstractDAO<Film> {
    public FilmDAO(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }
    public Film getAvailableFilmForRent() {

        Query<Film> query= getSession().createQuery("select f from Film f " +
                "where f.id not in(select distinct film.id from Inventory)",Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}

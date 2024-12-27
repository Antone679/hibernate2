package service;

import dao.ActorDAO;
import dao.CategoryDAO;
import dao.FilmDAO;
import dao.LanguageDAO;
import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Set;
import java.util.stream.Collectors;

public class FilmService {
    private final FilmDAO filmDAO;
    private final ActorDAO actorDAO;
    private final LanguageDAO languageDAO;
    private final SessionFactory sessionFactory;
    private final CategoryDAO categoryDAO;

    public FilmService(FilmDAO filmDAO, ActorDAO actorDAO, LanguageDAO languageDAO, SessionFactory sessionFactory, CategoryDAO categoryDAO) {
        this.filmDAO = filmDAO;
        this.actorDAO = actorDAO;
        this.languageDAO = languageDAO;
        this.sessionFactory = sessionFactory;
        this.categoryDAO = categoryDAO;
    }

    public void newFilmAvailable(){
        try(Session session= sessionFactory.getCurrentSession()) {

            session.beginTransaction();

            Language language = languageDAO.getItems(0, 4).stream().unordered().findAny().get();
            Set<Actor> actors =  actorDAO.getItems(0, 5).stream().collect(Collectors.toSet());

            Set<Category> categories=  categoryDAO.getItems(0, 3).stream().collect(Collectors.toSet());
            Film film=new Film();
            film.setActors(actors);
            film.setLanguage(language);
            film.setCategories(categories);
            film.setTitle("Big film");
            film.setReleaseYear(2024);
            film.setRentalDuration((byte) 4);
            film.setRentalRate(BigDecimal.valueOf(0.99));
            film.setRating(Rating.NC_17);
            film.setReplacementCost(BigDecimal.valueOf(21.99));
            filmDAO.save(film);
            session.getTransaction().commit();
        }
    }

    public FilmDAO getFilmDAO() {
        return filmDAO;
    }

    public ActorDAO getActorDAO() {
        return actorDAO;
    }

    public LanguageDAO getLanguageDAO() {
        return languageDAO;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public CategoryDAO getCategoryDAO() {
        return categoryDAO;
    }
}

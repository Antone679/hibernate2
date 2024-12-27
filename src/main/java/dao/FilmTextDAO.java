package dao;

import entity.City;
import entity.FilmText;
import org.hibernate.SessionFactory;

public class FilmTextDAO extends AbstractDAO<FilmText> {
    public FilmTextDAO(SessionFactory sessionFactory) {
        super(FilmText.class, sessionFactory);
    }
}

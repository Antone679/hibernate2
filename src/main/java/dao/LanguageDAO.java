package dao;

import entity.City;
import entity.Language;
import org.hibernate.SessionFactory;

public class LanguageDAO extends AbstractDAO<Language> {
    public LanguageDAO(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}

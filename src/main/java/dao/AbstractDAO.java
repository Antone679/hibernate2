package dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

public abstract class AbstractDAO<T> {

    private Class<T> clazz;
    private SessionFactory sessionFactory;

    protected AbstractDAO(Class<T> clazz, SessionFactory sessionFactory) {
        this.clazz = clazz;
        this.sessionFactory = sessionFactory;
    }

    public T getById(int id) {
        return sessionFactory.getCurrentSession().get(clazz, id);

    }

    public List<T> getItems(int offset, int limit) {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM " +
                clazz.getName(), clazz);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createQuery("FROM " +
                clazz.getName(), clazz).getResultList();
    }

    public void save(T entity) {

        sessionFactory.getCurrentSession().persist(entity);
    }

    public T update(T entity) {

        sessionFactory.getCurrentSession().merge(entity);

        return entity;
    }

    public T remove(T entity) {

        sessionFactory.getCurrentSession().remove(entity);

        return entity;
    }

    public void removeById(int id) {

        remove(getById(id));
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

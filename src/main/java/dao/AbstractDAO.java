package dao;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        Query query = sessionFactory.getCurrentSession().createQuery("SELECT c FROM " +
                clazz.getName() + " c", clazz);
        query.setFirstResult(offset);
        query.setMaxResults(limit);

        return query.getResultList();
    }

    public List<T> findAll() {
        return sessionFactory.getCurrentSession().createQuery("SELECT c FROM " +
                clazz.getName() + " c", clazz).getResultList();
    }

    public T save (T entity){

        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            session.saveOrUpdate(entity);

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
        return entity;
    }

    public T update(T entity) {
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            session.merge(entity);

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
        return entity;
    }

    public T remove(T entity){
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            session.remove(entity);

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
        return entity;
    }

    public boolean removeById(int id){
        Session session = null;
        Transaction transaction = null;

        try{
            session = sessionFactory.getCurrentSession();
            transaction = session.beginTransaction();

            remove(getById(id));

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
        return true;
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

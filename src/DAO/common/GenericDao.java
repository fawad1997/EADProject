package DAO.common;

import org.hibernate.Session;
import org.hibernate.StatelessSession;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {

    Session getSession();

    Session getThreadLocalSession() ;
    StatelessSession getStatelessSession();
    void closeSession(Session session);

    void closeSession(StatelessSession session);

    String save(T instance);
    T merge(T instance);

    String merge(List<T> instances);
    String save(List<T> instances);
    String save(T[] instances);
    String create(T instance);

    String delete(T instance);

    String delete(T[] instances);

    String delete(Class<T> clazz, ID id);

    T findById(Class<T> clazz, ID id);

    T findById(Session session, Class<T> clazz, ID id);

    T findById(Class<T> clazz, ID id, String[] associations);

    T findById(Class<T> clazz, ID id, String association);

    int countRecords(Class<T> clazz);
}

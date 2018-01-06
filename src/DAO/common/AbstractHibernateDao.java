package DAO.common;

import HibernateDB.Main;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import java.io.Serializable;
import java.util.List;


public abstract class AbstractHibernateDao<T, ID extends Serializable> implements GenericDao<T, ID> {

    public static final String SUCCESS = "Success";
    public static final String FAILURE = "Failure";
    public static final int ORDER_ASCENDING = 1;
    public static final int ORDER_DESCENDING = 2;

    /**
     * Default constructor.
     */
    public AbstractHibernateDao()
    {

    }

    @Override
    public Session getSession() {

        try {
            return Main.getCurrentSession();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Session getThreadLocalSession()
    {
        // logger.log("Hibernate Session oppend.");
        try {
            return Main.getCurrentThreadLocalSession();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public StatelessSession getStatelessSession() {
        try {
            return Main.openStatelessSession();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void closeSession(Session session) {
        try {
            if (session != null) {
                Main.closeSession(session);
                // logger.log("Hibernate Session closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void closeSession(StatelessSession session) {
        try {
            if (session != null) {
                Main.closeSession(session);
                // logger.log("Hibernate Session closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public String create(T instance)
    {
        String message = SUCCESS;
        if (instance == null) {
            message = FAILURE + " - null instance cannot be saved or updated";
            return message;
        }
        Session session = getSession();
        try
        {
            session.beginTransaction();
            session.save(instance);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            message = FAILURE;
            ex.printStackTrace();

        }

        return message;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T merge(T instance) {
        // String message = SUCCESS;
        if (instance == null) {
            // message = FAILURE + " - null instance cannot be saved or updated";
            // return message;

        }
        Session session = getSession();
        T instance2 = null;

        try {
            instance2 = (T) session.merge(instance);
            session.flush();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return instance2;
    }

    @Override
    public String save(T instance) {
        String message = SUCCESS;
        if (instance == null) {
            message = FAILURE + " - null instance cannot be saved or updated";
            return message;
        }
        Session session = getSession();
        try
        {
            session.beginTransaction();
            session.saveOrUpdate(instance);
            session.getTransaction().commit();
            // session.flush();

        } catch (HibernateException ex) {
            message = FAILURE;
            ex.printStackTrace();
        }

        return message;
    }

    @Override
    public String merge(List<T> instances) {
        String message = SUCCESS;
        if (instances == null) {
            message = FAILURE + " - null instance cannot be saved or updated";
            return message;
        }
        Session session = getSession();

        try {
            for (T instance : instances) {
                session.merge(instance);
                session.flush();
            }
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }

        return message;
    }

    @Override
    public String save(List<T> instances) {
        String message = SUCCESS;
        if (instances == null) {
            message = FAILURE + " - null instances cannot be saved or updated";
            return message;
        }
        Session session = Main.getCurrentSession();
        try {
            for (T detachedInstance : instances) {
                session.saveOrUpdate(detachedInstance);
            }
        } catch (HibernateException ex) {
            message = FAILURE;
            ex.printStackTrace();
        }

        return message;
    }

    @Override
    public String save(T[] instances) {
        String message = SUCCESS;
        if (instances == null) {
            message = FAILURE + " - null instance cannot be saved or updated";
            return message;
        }
        for (int i = 0; i < instances.length; i++) {
            Object object = instances[i];
            if (object == null) {
                message = FAILURE + " - null instance at " + i + " in object array. Nothing is saved or updated";

                return message;
            }
        }

        Session session = getSession();
        try {
            for (int i = 0; i < instances.length; i++) {
                session.saveOrUpdate(instances[i]);
            }
        } catch (HibernateException ex) {
            message = FAILURE;
            ex.printStackTrace();
        }

        return message;
    }

    @Override
    public String delete(T persistentInstance) {
        String message = SUCCESS;
        if (persistentInstance == null) {
            message = FAILURE + " - null instance cannot be deleted";
            return message;
        }
        Session session = getSession();
        try
        {
            session.beginTransaction();
            session.delete(persistentInstance);
            session.getTransaction().commit();
        } catch (HibernateException ex) {
            message = FAILURE;
            ex.printStackTrace();
        }

        return message;
    }

    @Override
    public String delete(T[] instances) {
        String message = SUCCESS;
        if (instances == null) {
            message = FAILURE + " - null instances cannot be deleted";
            return message;
        }
        Session session = getSession();
        try {
            for (Object object : instances) {
                session.delete(object);
            }
        } catch (HibernateException ex) {
            message = FAILURE;
            ex.printStackTrace();
        }

        return message;
    }

    @Override
    public String delete(Class<T> clazz, ID id) {
        String message = SUCCESS;
        if (id == null) {
            message = FAILURE + " - null id cannot be deleted";
            return message;
        }

        if (clazz == null) {
            message = FAILURE + " - null Object Class cannot be deleted";
            return message;
        }

        Session session = getSession();
        try {
            Object object = findById(session, clazz, id);

            if (object != null) {
                session.delete(object);
            }
        } catch (HibernateException ex) {
            message = FAILURE;
            ex.printStackTrace();
        }

        return message;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(Class<T> clazz, ID id)
    {
        if (id == null) {
            throw new IllegalArgumentException("null id cannot be retrieved");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("Persistent object type cannot be null");
        }

        Session session = getSession();

        try
        {
            session.beginTransaction();
            T t = (T) session.get(clazz, id);
            session.getTransaction().commit();
            return t;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(Session session, Class<T> clazz, ID id) {
        if (id == null) {
            throw new IllegalArgumentException("null id cannot be retrieved");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("Persistent object type cannot be null");
        }

        try {
            return (T) session.get(clazz, id);
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T findById(Class<T> clazz, ID id, String[] associations) {
        if (id == null) {
            throw new IllegalArgumentException("null id cannot be retrieved");
        }
        if (clazz == null) {
            throw new IllegalArgumentException("Persistent object type cannot be null");
        }

        Session session = getSession();

        try {
            Criteria criteria = session.createCriteria(clazz);
            if (associations != null) {
                for (String association : associations) {
                    criteria.setFetchMode(association, FetchMode.JOIN);
                }
            }
            criteria.add(Restrictions.idEq(id));
            return (T) criteria.uniqueResult();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return null;
        }
    }


    @Override
    public T findById(Class<T> clazz, ID id, String association) {
        String[] associations = { association };
        return findById(clazz, id, associations);
    }




    private void setOrderBy(Criteria criteria, String[] orderByFields, int orderByDirection) {

        if (orderByFields == null || orderByFields.length == 0) {
            // Do nothing if orderByFields is null or empty
            return;
        } else {
            for (String orderBy : orderByFields) {
                if (orderBy.endsWith("person.name")) {
                    setOrderByName(criteria, orderBy, orderByDirection);
                } else {
                    setOrderBy(criteria, orderBy, orderByDirection);
                }
            }
        }
    }

    private void setOrderByName(Criteria criteria, String orderBy, int orderByDirection) {
        String orderAssociation = orderBy.substring(0, orderBy.lastIndexOf('.'));
        System.out.println("8888888888888" + orderAssociation);
        Criteria cr = criteria.createCriteria(orderAssociation, JoinType.LEFT_OUTER_JOIN);
        switch (orderByDirection) {
            case ORDER_DESCENDING:
                cr.addOrder(Order.desc("lastName"));
                cr.addOrder(Order.desc("firstName"));
                cr.addOrder(Order.desc("middleName"));
                break;
            case ORDER_ASCENDING:
            default:
                cr.addOrder(Order.asc("lastName"));
                cr.addOrder(Order.asc("firstName"));
                cr.addOrder(Order.asc("middleName"));
        }
    }

    private void setOrderBy(Criteria criteria, String orderBy, int orderByDirection) {
        Order order = null;
        String orderProperty = null;
        String orderAssociation = null;
        boolean orderBySubEntity = false;

        if (orderBy != null && orderBy.trim().length() > 0) {
            orderProperty = orderBy;
            int dotIndex = orderBy.lastIndexOf('.');

            if (dotIndex >= 0) {
                orderBySubEntity = true;
                orderProperty = orderBy.substring(dotIndex + 1);
                orderAssociation = orderBy.substring(0, dotIndex);
                // System.out.println("Property: " + orderProperty +
                // "Association: " + orderAssociation);
            }

            switch (orderByDirection) {
                case ORDER_ASCENDING:
                    order = Order.asc(orderProperty);
                    break;
                case ORDER_DESCENDING:
                    order = Order.desc(orderProperty);
                    break;
                default:
                    order = Order.asc(orderProperty);
            }
        }
        if (order != null) {
            if (orderBySubEntity) {
                criteria.createCriteria(orderAssociation, JoinType.LEFT_OUTER_JOIN).addOrder(order);
            } else {
                criteria.addOrder(order);
            }
        }
    }


    @SuppressWarnings("rawtypes")
    @Override
    public int countRecords(Class<T> clazz)
    {
        Session session = getSession();
        try {
            List list = session.createQuery("select count(*) from " + clazz.getSimpleName()).list();
            Object obj = list.get(0);
            return Integer.parseInt(obj.toString());
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

}

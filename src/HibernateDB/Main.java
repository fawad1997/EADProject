package HibernateDB;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.service.ServiceRegistry;

import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Map;

public class Main {
    private static SessionFactory sessionFactory = null;
    private static ServiceRegistry serviceRegistry = null;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

    public static SessionFactory getSessionFactory()
    {

        if (sessionFactory == null)
        {
            try
            {
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }

    public static Session openSession()
    {
        return getSessionFactory().openSession();
    }

    public static StatelessSession openStatelessSession()
    {
        return getSessionFactory().openStatelessSession();
    }

    public static void closeSession(Session session)
    {
        if (session.isOpen())
        {
            session.close();
        }
    }

    public static void closeSession(StatelessSession session)
    {
        session.close();
    }

    public static Session getCurrentSession()
    {
        return openSession();
    }

    public static Session getCurrentThreadLocalSession()
    {
        Session session = (Session) threadLocal.get();

        if (session == null || !session.isOpen())
        {
            session = getSessionFactory().openSession();
            threadLocal.set(session);
        }


        return session;
    }

    public static void markCMTForRollback()
    {
        try
        {
            ((SessionContext) new InitialContext().lookup("java:comp/EJBContext")).setRollbackOnly();
        }
        catch (NamingException nex)
        {
            nex.printStackTrace();
        }
    }
}
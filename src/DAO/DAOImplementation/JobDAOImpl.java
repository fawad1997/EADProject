package DAO.DAOImplementation;

import DAO.DAOInterfaces.JobDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.JobEntity;
import HibernateDB.Main;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class JobDAOImpl extends AbstractHibernateDao<JobEntity,Integer> implements JobDAO {
    @Override
    public List<JobEntity> findall() {
        try {
            Transaction t = null;
            Session s = Main.openSession();
            t = s.beginTransaction();
            List<JobEntity> lst = s.createQuery("from JobEntity").list();
            t.commit();
            s.close();
            return lst;
        } catch (RuntimeException re) {
            re.printStackTrace();
            return null;
        }
    }
    public boolean deleteJobById(int id) {
        System.out.println(id);
        Session session = Main.openSession();
        Transaction t = session.beginTransaction();
        JobEntity jobtoDel = (JobEntity) session.load(JobEntity.class, id);
        session.delete(jobtoDel);
        t.commit();
        session.close();
        System.out.println("End Tk Chala");
        return true;
    }
    public JobEntity getJobById(int id) {
        System.out.println(id);
        Session session = Main.openSession();
        Transaction t = session.beginTransaction();
        JobEntity job = (JobEntity) session.load(JobEntity.class, id);
        session.close();
        return job;
    }
}

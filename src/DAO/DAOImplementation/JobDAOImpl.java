package DAO.DAOImplementation;

import DAO.DAOInterfaces.JobDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.JobEntity;

public class JobDAOImpl extends AbstractHibernateDao<JobEntity,Integer> implements JobDAO {
}

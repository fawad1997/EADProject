package DAO.DAOImplementation;

import DAO.DAOInterfaces.AdminDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.AdminEntity;

public class AdminDAOImpl extends AbstractHibernateDao<AdminEntity,Integer> implements AdminDAO {
}

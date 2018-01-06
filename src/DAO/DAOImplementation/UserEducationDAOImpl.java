package DAO.DAOImplementation;

import DAO.DAOInterfaces.UserEducationDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.UserEducationEntity;

public class UserEducationDAOImpl extends AbstractHibernateDao<UserEducationEntity,Integer> implements UserEducationDAO {
}

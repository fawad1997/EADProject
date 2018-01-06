package DAO.DAOImplementation;

import DAO.DAOInterfaces.UserExperienceDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.UserExperienceEntity;

public class UserExperienceDAOImpl extends AbstractHibernateDao<UserExperienceEntity,Integer> implements UserExperienceDAO {
}

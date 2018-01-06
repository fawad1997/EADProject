package DAO.DAOImplementation;

import DAO.DAOInterfaces.RatingDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.RatingEntity;

public class RatingDAOImpl extends AbstractHibernateDao<RatingEntity,Integer> implements RatingDAO {
}

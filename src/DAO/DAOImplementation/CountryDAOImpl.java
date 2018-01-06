package DAO.DAOImplementation;

import DAO.DAOInterfaces.CountryDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.CountryEntity;

public class CountryDAOImpl extends AbstractHibernateDao<CountryEntity,Integer> implements CountryDAO {
}

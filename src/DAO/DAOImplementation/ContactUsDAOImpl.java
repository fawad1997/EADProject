package DAO.DAOImplementation;

import DAO.DAOInterfaces.ContactUsDAO;
import DAO.common.AbstractHibernateDao;
import EntityModels.ContactUsEntity;

public class ContactUsDAOImpl extends AbstractHibernateDao<ContactUsEntity,Integer> implements ContactUsDAO {
}

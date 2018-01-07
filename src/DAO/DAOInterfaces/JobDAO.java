package DAO.DAOInterfaces;

import DAO.common.GenericDao;
import EntityModels.JobEntity;

import java.util.List;

public interface JobDAO extends GenericDao<JobEntity,Integer>{
    public List<JobEntity> findall();
    public boolean deleteJobById(int id);
    public JobEntity getJobById(int id);
}

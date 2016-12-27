package com.taiton.dao.employee;

import com.taiton.dao.AbstractDao;
import com.taiton.entity.EmployeeEntity;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Taiton on 12/24/2016.
 */
@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao {

    @Override
    @Transactional
    public EmployeeEntity find(int id) {
        TypedQuery query =  getSession().createQuery("from EmployeeEntity as e where e.idEmployee = :id", EmployeeEntity.class).
                setParameter("id", id);
        EmployeeEntity employee = (EmployeeEntity) query.getSingleResult();
        return employee;
    }

    @Override
    @Transactional
    public boolean save(EmployeeEntity employee) {
        persist(employee);
        return true;
    }

    @Override
    @Transactional
    public void delete(int id) {
        delete(id);
    }

    @Override
    @Transactional
    public void delete(EmployeeEntity employee) {
        delete(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeEntity> findAll() {
        Query query = getSession().createQuery("from EmployeeEntity");
        return query.list();
    }
}

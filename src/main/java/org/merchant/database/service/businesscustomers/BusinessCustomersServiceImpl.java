package org.merchant.database.service.businesscustomers;

import org.merchant.database.entity.BusinessCustomers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BusinessCustomersServiceImpl implements BusinessCustomersService {

    @PersistenceContext
    private EntityManager entityManager;

    private BusinessCustomersRepository dao;

    @Autowired
    public BusinessCustomersServiceImpl(BusinessCustomersRepository dao){
        this.dao = dao;
    }

    @Override
    public Page<BusinessCustomers> findAll(Specification spec, Pageable pageable)
    {
        return dao.findAll(spec, pageable);
    }

    @Override
    public int deleteByIds(List<Long> ids)
    {
        String hql = "delete from " + BusinessCustomers.class.getName() + " e WHERE e.id IN :ids";
        Query query = entityManager.createQuery(hql).setParameter("ids", ids);
        return query.executeUpdate();
    }

    @Override
    public Optional<BusinessCustomers> findById(Long id)
    {
        return dao.findById(id);
    }

    @Override
    public BusinessCustomers save(BusinessCustomers businessCustomers)
    {
        return dao.saveAndFlush(businessCustomers);
    }
}

package org.merchant.database.service.businesscustomers;

import org.merchant.database.entity.BusinessCustomers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface BusinessCustomersService {

    Page<BusinessCustomers> findAll(Specification spec, Pageable pageable);

    int deleteByIds(List<Long> ids);

    Optional<BusinessCustomers> findById(Long id);

    BusinessCustomers save(BusinessCustomers businessCustomers);
}

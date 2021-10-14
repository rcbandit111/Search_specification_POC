package org.merchant.database.service.businesscustomers;

import org.merchant.database.entity.BusinessCustomers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessCustomersRepository extends JpaRepository<BusinessCustomers, Long>, JpaSpecificationExecutor<BusinessCustomers> {
}

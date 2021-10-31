package org.merchant.service.businesscustomers;

import org.merchant.dto.businesscustomers.BusinessCustomersDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersFullDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersSearchParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BusinessCustomersRestService {

    Page<BusinessCustomersDTO> findBusinessCustomers(BusinessCustomersSearchParams params, Pageable pageable);

    int deleteBusinessCustomers(List<Long> ids);

    Optional<BusinessCustomersFullDTO> findBusinessCustomer(Long id);

    Optional<BusinessCustomersFullDTO> updateBusinessCustomer(Long id, BusinessCustomersFullDTO businessCustomersFullDTO);

    BusinessCustomersFullDTO createBusinessCustomer(BusinessCustomersFullDTO businessCustomersFullDTO);
}

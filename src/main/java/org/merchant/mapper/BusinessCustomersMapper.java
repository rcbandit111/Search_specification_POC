package org.merchant.mapper;

import org.mapstruct.Mapper;
import org.merchant.config.BaseMapperConfig;
import org.merchant.database.entity.BusinessCustomers;
import org.merchant.dto.businesscustomers.BusinessCustomersDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersFullDTO;

@Mapper(config = BaseMapperConfig.class)
public interface BusinessCustomersMapper {

	BusinessCustomersFullDTO toFullDTO(BusinessCustomers businessCustomers);

	BusinessCustomersDTO toDTO(BusinessCustomers businessCustomers);
}

package org.merchant.mapper;

import javax.annotation.processing.Generated;
import org.merchant.database.entity.BusinessCustomers;
import org.merchant.dto.businesscustomers.BusinessCustomersDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersDTO.BusinessCustomersDTOBuilder;
import org.merchant.dto.businesscustomers.BusinessCustomersFullDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersFullDTO.BusinessCustomersFullDTOBuilder;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-31T15:56:16+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.2.jar, environment: Java 17 (Oracle Corporation)"
)
@Component
public class BusinessCustomersMapperImpl implements BusinessCustomersMapper {

    @Override
    public BusinessCustomersFullDTO toFullDTO(BusinessCustomers businessCustomers) {
        if ( businessCustomers == null ) {
            return null;
        }

        BusinessCustomersFullDTOBuilder businessCustomersFullDTO = BusinessCustomersFullDTO.builder();

        if ( businessCustomers.getId() != null ) {
            businessCustomersFullDTO.id( businessCustomers.getId() );
        }
        businessCustomersFullDTO.status( businessCustomers.getStatus() );
        businessCustomersFullDTO.description( businessCustomers.getDescription() );
        businessCustomersFullDTO.country( businessCustomers.getCountry() );
        businessCustomersFullDTO.address1( businessCustomers.getAddress1() );

        return businessCustomersFullDTO.build();
    }

    @Override
    public BusinessCustomersDTO toDTO(BusinessCustomers businessCustomers) {
        if ( businessCustomers == null ) {
            return null;
        }

        BusinessCustomersDTOBuilder businessCustomersDTO = BusinessCustomersDTO.builder();

        if ( businessCustomers.getId() != null ) {
            businessCustomersDTO.id( businessCustomers.getId() );
        }
        businessCustomersDTO.status( businessCustomers.getStatus() );
        businessCustomersDTO.description( businessCustomers.getDescription() );
        businessCustomersDTO.country( businessCustomers.getCountry() );
        businessCustomersDTO.address1( businessCustomers.getAddress1() );

        return businessCustomersDTO.build();
    }
}

package org.merchant.database.service.businesscustomers;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BusinessCustomersStatusAttributeConverter
        implements AttributeConverter<BusinessCustomersStatus, String> {

    public String convertToDatabaseColumn( BusinessCustomersStatus value ) {
        if ( value == null ) {
            return null;
        }

        return value.getStatus();
    }

    public BusinessCustomersStatus convertToEntityAttribute( String value ) {
        if ( value == null ) {
            return null;
        }

        return BusinessCustomersStatus.fromStatus( value );
    }

}
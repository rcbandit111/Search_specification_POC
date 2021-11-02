package org.merchant.dto.businesscustomers;

import lombok.*;
import org.merchant.database.service.businesscustomers.BusinessCustomersStatus;
import org.merchant.database.service.businesscustomers.BusinessCustomersType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BusinessCustomersDTO {

    private long id;

    private String name;

    private BusinessCustomersType type;

    private BusinessCustomersStatus status;

    private String description;

    private String country;

    private String address1;
}

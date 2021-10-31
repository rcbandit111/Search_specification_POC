package org.merchant.dto.businesscustomers;

import lombok.*;
import org.merchant.database.service.businesscustomers.BusinessCustomersStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BusinessCustomersDTO {

    private long id;

    private String name;

    private String businessType;

    private BusinessCustomersStatus status;

    private String description;

    private String country;

    private String address1;
}

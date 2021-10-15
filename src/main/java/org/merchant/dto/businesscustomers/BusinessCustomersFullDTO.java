package org.merchant.dto.businesscustomers;

import lombok.*;
import org.merchant.database.service.businesscustomers.BusinessCustomersStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BusinessCustomersFullDTO {

    private long id;

    private String name;

    private String businessType;

    private String status;

    private String description;

    private String country;

    private String address1;
}

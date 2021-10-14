package org.merchant.dto.businesscustomers;

import lombok.Getter;
import lombok.Setter;
import org.merchant.database.service.businesscustomers.BusinessCustomersStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BusinessCustomersSearchParams {

    private String title;

    private List<BusinessCustomersStatus> status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

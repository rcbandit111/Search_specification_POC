package org.merchant.dto.businesscustomers;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class BusinessCustomersSearchParams {

    private String title;

    private List<String> status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

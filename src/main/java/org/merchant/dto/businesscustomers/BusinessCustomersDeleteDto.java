package org.merchant.dto.businesscustomers;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BusinessCustomersDeleteDto {

    private List<Long> ids;
}

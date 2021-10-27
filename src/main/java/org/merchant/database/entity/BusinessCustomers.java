package org.merchant.database.entity;

import lombok.*;
import org.merchant.database.service.businesscustomers.BusinessCustomersStatus;
import org.merchant.database.service.businesscustomers.BusinessCustomersType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "business_customers")
public class BusinessCustomers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, updatable = false, nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", length = 100)
    private BusinessCustomersType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private BusinessCustomersStatus status;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "address1", length = 200)
    private String address1;
}

package org.merchant.service.businesscustomers;

import org.merchant.database.entity.BusinessCustomers;
import org.merchant.database.service.businesscustomers.BusinessCustomersService;
import org.merchant.database.service.businesscustomers.BusinessCustomersStatus;
import org.merchant.dto.businesscustomers.BusinessCustomersDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersFullDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersSearchParams;
import org.merchant.mapper.BusinessCustomersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusinessCustomersRestServiceImpl implements BusinessCustomersRestService {

    private BusinessCustomersService businessCustomersService;
    private BusinessCustomersMapper businessCustomersMapper;

    @Autowired
    public BusinessCustomersRestServiceImpl(BusinessCustomersService businessCustomersService,
                                            BusinessCustomersMapper businessCustomersMapper) {
        this.businessCustomersService = businessCustomersService;
        this.businessCustomersMapper = businessCustomersMapper;
    }

    @Override
    public Page<BusinessCustomersDTO> findBusinessCustomers(BusinessCustomersSearchParams params, Pageable pageable)
    {
        Specification<BusinessCustomers> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (params.getTitle() != null) {
                predicates.add(cb.like(cb.lower(root.get("description")), "%" + params.getTitle().toLowerCase() + "%"));
            }

            final List<String> statuses = Optional.ofNullable(params.getStatus()).orElse(Collections.emptyList());
            if (statuses != null && !statuses.isEmpty()){
                EnumSet<BusinessCustomersStatus> businessCustomersStatusEnumSet = EnumSet.allOf(BusinessCustomersStatus.class);
                
                List<BusinessCustomersStatus> statusesAsEnum = statuses.stream()
                        .filter(status -> businessCustomersStatusEnumSet
                            .stream()
                            .filter(e -> e.getShortName().equals(status))
                            .findAny()
                            .isPresent()
                        )
                        .map(status -> BusinessCustomersStatus.fromStatus(status))
                        .collect(Collectors.toList())
                        ;

                predicates.add(root.get("status").in(statusesAsEnum));
            }

            return cb.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        return businessCustomersService.findAll(spec, pageable).map(businessCustomersMapper::toDTO);
    }

    @Override
    public int deleteBusinessCustomers(List<Long> ids)
    {
        return businessCustomersService.deleteByIds(ids);
    }

    @Override
    public Optional<BusinessCustomersFullDTO> findBusinessCustomer(Long id)
    {
        return businessCustomersService.findById(id).map( businessCustomers -> businessCustomersMapper.toFullDTO(businessCustomers));
    }

    @Override
    public Optional<BusinessCustomersFullDTO> updateBusinessCustomer(Long id, BusinessCustomersFullDTO dto)
    {
        Optional<BusinessCustomers> byId = businessCustomersService.findById(id);
        if(byId.isPresent())
        {
            BusinessCustomers businessCustomers = byId.get();
            businessCustomers.setStatus(dto.getStatus());
            businessCustomers.setDescription(dto.getDescription());
            businessCustomers.setCountry(dto.getCountry());
            businessCustomers.setAddress1(dto.getAddress1());

            BusinessCustomers insertedBusinessCustomer = businessCustomersService.save(businessCustomers);
            BusinessCustomersFullDTO businessCustomersFullDTO = businessCustomersMapper.toFullDTO(insertedBusinessCustomer);

            return Optional.of(businessCustomersFullDTO);
        }

        return Optional.empty();
    }

    @Override
    public BusinessCustomersFullDTO createBusinessCustomer(BusinessCustomersFullDTO dto)
    {
        BusinessCustomers businessCustomers = new BusinessCustomers();
        businessCustomers.setStatus(dto.getStatus());
        businessCustomers.setDescription(dto.getDescription());
        businessCustomers.setCountry(dto.getCountry());
        businessCustomers.setAddress1(dto.getAddress1());

        BusinessCustomers insertedBusinessCustomer = businessCustomersService.save(businessCustomers);
        BusinessCustomersFullDTO businessCustomersFullDTO = businessCustomersMapper.toFullDTO(insertedBusinessCustomer);

        return businessCustomersFullDTO;
    }
}

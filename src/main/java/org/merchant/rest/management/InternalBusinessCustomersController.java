package org.merchant.rest.management;

import org.merchant.dto.businesscustomers.BusinessCustomersDeleteDto;
import org.merchant.dto.businesscustomers.BusinessCustomersFullDTO;
import org.merchant.dto.businesscustomers.BusinessCustomersSearchParams;
import org.merchant.service.businesscustomers.BusinessCustomersRestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/management/business_customers")
public class InternalBusinessCustomersController {

    private static final Logger LOG = LoggerFactory.getLogger(InternalBusinessCustomersController.class);

    private BusinessCustomersRestService businessCustomersRestService;

    @Autowired
    public InternalBusinessCustomersController(BusinessCustomersRestService businessCustomersRestService)
    {
        this.businessCustomersRestService = businessCustomersRestService;
    }

    /**
     * Create BusinessCustomer
     * @param businessCustomersFullDTO
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody BusinessCustomersFullDTO businessCustomersFullDTO)
    {
        BusinessCustomersFullDTO businessCustomer = businessCustomersRestService.createBusinessCustomer(businessCustomersFullDTO);
        return new ResponseEntity<>(businessCustomer, HttpStatus.OK);
    }

    /**
     * List Business Customers
     * @param params
     * @param pageable
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listBusinessCustomers(@Valid BusinessCustomersSearchParams params, Pageable pageable)
    {
        Page<BusinessCustomersFullDTO> businessCustomersList = businessCustomersRestService.findBusinessCustomers(params, pageable);
        return new ResponseEntity<>(businessCustomersList, HttpStatus.OK);
    }

    /**
     * Get single Business Customers
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTicket(@RequestParam(required = true, name = "id") Long id)
    {
        Optional<BusinessCustomersFullDTO> businessCustomer = businessCustomersRestService.findBusinessCustomer(id);
        if(businessCustomer.isPresent())
        {
            return new ResponseEntity<>(businessCustomer, HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }

    /**
     * Update Business Customers by Id
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/customers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateTicket(@PathVariable("id") Long id, @RequestBody BusinessCustomersFullDTO businessCustomersFullDTO)
    {
        Optional<BusinessCustomersFullDTO> businessCustomer = businessCustomersRestService.updateBusinessCustomer(id, businessCustomersFullDTO);
        if(businessCustomer.isPresent())
        {
            return new ResponseEntity<>(businessCustomer, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Delete Business Customer
     * @param dto
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/customers")
    public ResponseEntity<?> deleteBusinessCustomer(@Valid BusinessCustomersDeleteDto dto)
    {
        int deletedItems = businessCustomersRestService.deleteBusinessCustomers(dto.getIds());
        if(deletedItems > 0)
        {
            return new ResponseEntity<>(deletedItems, HttpStatus.OK);
        }
        return ResponseEntity.noContent().build();
    }
}

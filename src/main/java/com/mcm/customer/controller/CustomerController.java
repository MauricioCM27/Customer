package com.mcm.customer.controller;

import com.mcm.customer.dto.CustomerRequest;
import com.mcm.customer.dto.CustomerResponse;
import com.mcm.customer.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(
        path = "api/customers"
)
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.createCustomer(request));
    }

    @DeleteMapping("/{identification}")
    ResponseEntity<Void> deleteCustomerByIdentification(@PathVariable(name = "identification") String identification) {
        customerService.deleteByIdentification(identification);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    List<CustomerResponse> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/{identification}")
    CustomerResponse findByIdentification(@PathVariable(name = "identification") String identification) {
        return customerService.findByIdentification(identification);
    }

}

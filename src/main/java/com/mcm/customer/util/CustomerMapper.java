package com.mcm.customer.util;

import com.mcm.customer.dto.CustomerRequest;
import com.mcm.customer.dto.CustomerResponse;
import com.mcm.customer.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer mapCustomerRequestToCustomer(CustomerRequest request) {
        final Customer customer = new Customer();

        customer.setIdentification(request.identification());
        customer.setName(request.name());
        customer.setLastname(request.lastname());

        return customer;
    }

    public CustomerResponse mapCustomerToCustomerResponse(Customer customer) {
        return new CustomerResponse(customer.getId().toString(), customer.getIdentification(), customer.getName(), customer.getLastname());
    }

}

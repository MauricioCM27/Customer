package com.mcm.customer.service;

import com.mcm.customer.dto.CustomerRequest;
import com.mcm.customer.dto.CustomerResponse;

import java.util.List;

public interface ICustomerService {

    CustomerResponse createCustomer(CustomerRequest request);

    CustomerResponse findByIdentification(String identification);

    List<CustomerResponse> findAll();

    void deleteByIdentification(String identification);

}

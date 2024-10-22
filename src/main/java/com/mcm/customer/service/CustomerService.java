package com.mcm.customer.service;

import com.mcm.customer.dto.CustomerRequest;
import com.mcm.customer.dto.CustomerResponse;
import com.mcm.customer.exception.NotFoundException;
import com.mcm.customer.model.Customer;
import com.mcm.customer.repository.ICustomerRepository;
import com.mcm.customer.util.CustomerMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerMapper customerMapper;

    private final ICustomerRepository customerRepository;

    public CustomerService(final CustomerMapper customerMapper,
                           final ICustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerResponse createCustomer(final CustomerRequest request) {
        final Customer customer = customerMapper.mapCustomerRequestToCustomer(request);

        final Customer customerSaved = customerRepository.save(customer);

        return customerMapper.mapCustomerToCustomerResponse(customerSaved);
    }

    @Override
    public CustomerResponse findByIdentification(final String identification) {

        final Customer customer = customerRepository
                .findByIdentification(identification)
                .orElseThrow(() -> new NotFoundException(String.format("Customer %s was not found", identification)));

        return customerMapper.mapCustomerToCustomerResponse(customer);
    }

    @Override
    public List<CustomerResponse> findAll() {
        return customerRepository
                .findAll()
                .stream()
                .map(customerMapper::mapCustomerToCustomerResponse)
                .toList();
    }

    @Override
    @Transactional
    public void deleteByIdentification(String identification) {
        customerRepository.deleteByIdentification(identification);
    }
}

package com.mcm.customer.repository;

import com.mcm.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, UUID> {

    Optional<Customer> findByIdentification(String identification);

    void deleteByIdentification(String identification);

}

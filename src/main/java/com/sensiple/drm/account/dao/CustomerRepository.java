package com.sensiple.drm.account.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sensiple.drm.account.entity.Customer;


/**
 * @author saravanan.k
 *
 */
@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findCustomerByCustomerId(int customerId);



}

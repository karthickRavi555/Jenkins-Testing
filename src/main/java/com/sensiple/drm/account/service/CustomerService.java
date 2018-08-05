package com.sensiple.drm.account.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sensiple.drm.account.entity.Customer;
import com.sensiple.drm.account.entity.Upload;

 /**
 * @author saravanan.k
 *
 */
public interface CustomerService {
	

	public Customer saveCustomer(Customer Customer);
	public List<Customer> findAll();
	public Customer findCustomerById(int customerId);
	public Upload storeFile(MultipartFile file) throws IOException;

}

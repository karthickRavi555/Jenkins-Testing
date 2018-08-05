package com.sensiple.drm.account.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sensiple.drm.account.constants.ApiMapping;
import com.sensiple.drm.account.entity.Customer;
import com.sensiple.drm.account.entity.Upload;
import com.sensiple.drm.account.entity.UploadFileResponse;
import com.sensiple.drm.account.service.CustomerService;


/**
 *  This class is used to process Customer Controller.
 *  
*/


/**
 * @author saravanan.k
 *
 */
@RestController
public class CustomerController {
	

@Autowired
private CustomerService customerService;

@PostMapping(ApiMapping.SAVE_CUSTOMER)
@Secured("ROLE_SUPER_ADMIN")
public Customer saveCustomer(@RequestBody Customer customer) {
	//System.out.println(customer.getCustomerName());
	customerService.saveCustomer(customer);
	return customer;
}

@Cacheable(value = "allaccount") 
@Secured("ROLE_SUPER_ADMIN")
@RequestMapping(ApiMapping.GET_ALL_CUSTOMER)
public List<Customer> getCustomer() {
	return customerService.findAll();
}

@Cacheable(value = "account", key = "#customerId") 
@RequestMapping(ApiMapping.GET_CUSTOMER)
@Secured("ROLE_SUPER_ADMIN")
public Customer getCustomer(@PathVariable int customerId) {
	Customer customer = customerService.findCustomerById(customerId);
	return customer;
}

@PostMapping(ApiMapping.UPLOAD)
public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
	Upload upload = customerService.storeFile(file);

   /* String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(customer.getCustomerId())
            .toUriString();
*/
    return new UploadFileResponse(upload.getFileName(), file.getContentType(), file.getSize());
}
}

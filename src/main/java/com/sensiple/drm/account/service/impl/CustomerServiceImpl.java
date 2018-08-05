package com.sensiple.drm.account.service.impl;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sensiple.drm.account.dao.CustomerRepository;
import com.sensiple.drm.account.dao.UploadRepository;
import com.sensiple.drm.account.entity.Customer;
import com.sensiple.drm.account.entity.Upload;
import com.sensiple.drm.account.exception.FileStorageException;
import com.sensiple.drm.account.service.CustomerService;
import com.sensiple.drm.account.utility.SecurityUtil;



/**
 * @author saravanan.k
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService{
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomerServiceImpl.class);

	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	UploadRepository uploadRepository;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("createCustomer----start--->" + System.currentTimeMillis());
				}
		if(customer.getCustomerId() == 0){
			customer.setCreatedOn(new Timestamp(System.currentTimeMillis()));
			customer.setCreatedBy(new String(SecurityUtil.loggedInUser()));
		}else{
			customer.setModifiedOn(new Timestamp(System.currentTimeMillis()));
			customer.setModifiedBy(new String(SecurityUtil.loggedInUser()));
		}  
			customerRepository.save(customer);
		if (LOGGER.isInfoEnabled()) {
					LOGGER.info("createCustomer: Success");
			}
				return customer;
	}
		
	public Customer findCustomerById(int customerId) {
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("GetCustomerById----start--->" + System.currentTimeMillis());
				}
		System.out.println("Cached Pages");
		 
		 if (LOGGER.isInfoEnabled()) {
				LOGGER.info("GetCustomerById: Success");
		}
			return customerRepository.findCustomerByCustomerId(customerId);
	}
	public List<Customer> findAll() {
		if(LOGGER.isInfoEnabled()) {
			LOGGER.info("GetAllCustomer----start--->" + System.currentTimeMillis());
				}
		System.out.println("Cached Pages");
		 
		 if (LOGGER.isInfoEnabled()) {
				LOGGER.info("GetAllCustomer: Success");
		}
		return customerRepository.findAll();
	}
	
	

    public Upload storeFile(MultipartFile file) throws IOException {
        // Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

     try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Upload upload = new Upload(fileName, file.getContentType(),file.getBytes());

            return uploadRepository.save(upload);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

}

package com.sensiple.drm.account.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;


/**
 * The persistent class for the customer_master database table.
 * 
 */
/**
 * @author saravanan.k
 *
 */
@Entity
@Table(name="sensiple_customer_master")
@DynamicUpdate
public class Customer implements Serializable {
	
	
	private static final long serialVersionUID = 516737435104864696L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;

	@Column(name="customer_address")
	private String customerAddress;

	@Column(name="customer_comments")
	private String customerComments;

	@Column(name="customer_contact_name")
	private String customerContactName;

	@Column(name="customer_contact_number")
	private String customerContactNumber;

	@Column(name="customer_name")
	private String customerName;

	@Column(name="customer_url")
	private String customerUrl;
	
	@Email
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="website")
	private String website;
	
	@Lob
	@Column(name="data")
	private byte [] data; 
	
	@Column(name = "activate_license")
	private Date activateLicense;
	
	@Column(name = "license_expiry")
	private Date licenseExpiry;
	
	@Column(name = "license_count")
	private int licenseCount;
	
	@Column(name = "account_status")
	private boolean activated;

	@Column(name = "created_on", insertable = true, updatable = false)
	private Timestamp createdOn;

	@Column(name = "modified_on", insertable = false, updatable = true)
	private Timestamp modifiedOn;

	@Column(name = "created_by", insertable = true, updatable = false)
	private String createdBy;

	@Column(name = "modified_by", insertable = false, updatable = true)
	private String modifiedBy;

	
	
	public Customer(byte[] data) {
		this.data=data;
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerComments() {
		return customerComments;
	}

	public void setCustomerComments(String customerComments) {
		this.customerComments = customerComments;
	}

	public String getCustomerContactName() {
		return customerContactName;
	}

	public void setCustomerContactName(String customerContactName) {
		this.customerContactName = customerContactName;
	}

	public String getCustomerContactNumber() {
		return customerContactNumber;
	}

	public void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerUrl() {
		return customerUrl;
	}

	public void setCustomerUrl(String customerUrl) {
		this.customerUrl = customerUrl;
	}
	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Date getActivateLicense() {
		return activateLicense;
	}

	public void setActivateLicense(Date activateLicense) {
		this.activateLicense = activateLicense;
	}

	public Date getLicenseExpiry() {
		return licenseExpiry;
	}

	public void setLicenseExpiry(Date licenseExpiry) {
		this.licenseExpiry = licenseExpiry;
	}

	public int getLicenseCount() {
		return licenseCount;
	}

	public void setLicenseCount(int licenseCount) {
		this.licenseCount = licenseCount;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getCreatedBy() {
		return StringUtils.isBlank(createdBy) ? "System" : createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return StringUtils.isBlank(modifiedBy) ? "System" : modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	
}
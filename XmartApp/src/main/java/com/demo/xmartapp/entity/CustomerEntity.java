package com.demo.xmartapp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.demo.xmartapp.dto.CustomerDTO;

@Entity
@Validated
public class CustomerEntity {
    @NotNull(message = "{email.absent}")
    @Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+", message = "{invalid.email.format}")
    @Id
    private String emailId;
    private String name;
    @NotNull(message = "{password.absent}")
    @Pattern(regexp = ".*[A-Z]{1,12}.*", message = "{invalid.password.format.uppercase}")
    @Pattern(regexp = ".*[a-z]{1,12}.*", message = "{invalid.password.format.lowercase}")
    @Pattern(regexp = ".*[\\d]{1,12}.*", message = "{invalid.password.format.number}")
    @Pattern(regexp = ".{0,14}[^a-zA-Z-0-9].{0,14}", message = "{invalid.password.format.specialcharacter}")
    private String password;

    @Valid
    @Size(max=10, min = 10, message = "{customer.invalid.phonenumber}")
    @Pattern(regexp="(^$|[\\d]{10})", message = "{customer.invalid.phonenumber}")
    private String phoneNumber;
    private String address;




    public String getEmailId() {
        return emailId;
    }
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

	/*
	 * public String getName() { return name; }
	 */
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

	/*
	 * public String getPhoneNumber() { return phoneNumber; }
	 */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

	/*
	 * public String getAddress() { return address; }
	 */
    public void setAddress(String address) {
        this.address = address;
    }
    
	
	  public CustomerEntity() {
	  
	  }
	 
    
	public CustomerEntity(CustomerDTO customerDTO) {
		this.setEmailId(customerDTO.getEmailId());
		this.setAddress(customerDTO.getAddress());
		this.setPassword(customerDTO.getPassword());
		this.setName(customerDTO.getName());
		this.setPhoneNumber(customerDTO.getPhoneNumber());
	}

}

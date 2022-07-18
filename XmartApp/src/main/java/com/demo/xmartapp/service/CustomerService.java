package com.demo.xmartapp.service;

import java.util.List;

import com.demo.xmartapp.dto.CustomerDTO;
import com.demo.xmartapp.entity.CustomerEntity;

public interface CustomerService {

    
	CustomerEntity registerNewCustomer(CustomerDTO customerDTO);

    List<CustomerEntity> fetchCustomerList();
    
    CustomerEntity updatePassword(CustomerDTO customerDTO);
    
    void deleteCustomerById(String emailId);
    

}

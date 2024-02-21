package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.respository.CustomerRepo;

import java.util.List;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;
    
    @Autowired
    public CustomerService(CustomerRepo customerRepo)
    {
        this.customerRepo=customerRepo;
    }

    // @Override
    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    // @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepo.findById(customerId).orElse(null);
    }

    // @Override
    public Customer createCustomer(Customer customer) {
        Customer customer2 =  customerRepo.save(customer);
        return customer2;
    }

    // @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer existingCustomer = customerRepo.findById(customerId).orElse(null);
        if (existingCustomer != null) {
            existingCustomer.setFirstName(customer.getFirstName());
            existingCustomer.setLastName(customer.getLastName());
            existingCustomer.setEmail(customer.getEmail());
            existingCustomer.setPhoneNumber(customer.getPhoneNumber());
            return customerRepo.save(existingCustomer);
        }
        return null;
    }

    // @Override
    public void deleteCustomer(Long customerId) {
        customerRepo.deleteById(customerId);
    }
}

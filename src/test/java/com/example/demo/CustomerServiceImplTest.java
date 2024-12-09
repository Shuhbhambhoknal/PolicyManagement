package com.example.demo;

//public class CustomerServiceImplTest {
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.capg.policyapp.controller.CustomerController;
import com.capg.policyapp.exception.InvalidEntityException;
import com.capg.policyapp.model.Customer;
import com.capg.policyapp.service.CustomerServiceImpl;


@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {

    @Mock
    CustomerServiceImpl customerService;

    @InjectMocks
    CustomerController customerController;

    @Test
    void testAddCustomer() throws InvalidEntityException {
        Customer customer = new Customer();

        when(customerService.addCustomer(customer)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.addCustomer(customer);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

    @Test
    void testUpdateCustomerEmailId() throws InvalidEntityException {
        long customerId = 123;
        String emailId = "test@example.com";

        Customer updatedCustomer = new Customer();
        updatedCustomer.setCustomerId(customerId);
        updatedCustomer.setEmailId(emailId);

        when(customerService.updateCustomerEmailId(customerId, emailId)).thenReturn(updatedCustomer);

        ResponseEntity<Customer> response = customerController.updateCustomerEmailId(customerId, emailId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCustomer, response.getBody());
    }

    @Test
    void testViewAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());

        when(customerService.viewAllCustomers()).thenReturn(customers);

        ResponseEntity<List<Customer>> response = customerController.viewAllCustomers();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customers, response.getBody());
    }

    @Test
    void testViewCustomerById() throws InvalidEntityException {
        long customerId = 123;
        Customer customer = new Customer();
        customer.setCustomerId(customerId);

        when(customerService.viewCustomerById(customerId)).thenReturn(customer);

        ResponseEntity<Customer> response = customerController.viewCustomerById(customerId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(customer, response.getBody());
    }

}



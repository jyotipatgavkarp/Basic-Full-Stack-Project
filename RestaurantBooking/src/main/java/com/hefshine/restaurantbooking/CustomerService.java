package com.hefshine.restaurantbooking;

import java.util.List;

public interface CustomerService {
 
	public List<Customer> showAllCustomer();
	
	public Customer addCustomer (Customer customer);
	
	public void deleteCustomerbyid(int id);
	
}

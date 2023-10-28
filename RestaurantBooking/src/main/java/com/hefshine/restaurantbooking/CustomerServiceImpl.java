package com.hefshine.restaurantbooking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	@Override
	public List<Customer> showAllCustomer() {
		List<Customer>list = customerRepo.findAll();	
		return list;
	}
	@Override
	public Customer addCustomer(Customer customer) {
		Customer cos = customerRepo.save(customer);
		return cos;
	}
	@Override
	public void deleteCustomerbyid(int id) {
         customerRepo.deleteById(id);	
         return;
	}
         
}

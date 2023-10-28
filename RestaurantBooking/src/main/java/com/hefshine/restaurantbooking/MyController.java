package com.hefshine.restaurantbooking;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyController {

	@Autowired
	CustomerService customerService;

	@Autowired
	UserRepo userRepo;
	@RequestMapping("load")
	public List<Customer> load() {
		System.out.println("in load");
		List<Customer> list =customerService.showAllCustomer();
		return list;
	}

	@RequestMapping("add")
	public Customer add(@RequestBody Customer customer) {
		System.out.println("in add");
		Customer customer2 = customerService.addCustomer(customer);
		return customer2;
	}

	@RequestMapping("delete{id}")
	public boolean delete(@PathVariable("id") int id) {
		System.out.println("in delete");
		try {
	      customerService.deleteCustomerbyid(id);
		     return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		     
		
	}

	@RequestMapping("logged/{username}and{password}")
	public int login(@PathVariable("username") String username, @PathVariable("password") String password) {	  
		System.out.println("logged in");
		List<User> list=userRepo.findAll();
	    for(User user:list)
	    {
	    	if(username.equals(user.getUsername()))
	    	{
	    		if(password.equals(user.getPassword()))
	    		{
	    			
	    			if(user.getActive()==1)
		    		
		    			return 3;
		    		
	    			else 
	    				return 2;
	    		}
	    		else 
	    		
	    			return 1;
	    		
	    		
	    	}
	    }
	    	return 0;
	    
	}
	
	@RequestMapping("register")
	public boolean register(@RequestBody User user)
	{
		try {
			user.setActive(0);;
			userRepo.save(user);
			return true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	
	
	
	
	
	
	
	
//	@RequestMapping("logged/{username}and{password}")
//	public int login(@PathVariable("username") String username, @PathVariable("password") String password) {
//	  
//		System.out.println("logged in");
//	    if (username.equals("abc") && password.equals("123")) {
//	        return 1; // login
//	    } else {
//	        return 0; // no login
//	    }
//	}
	
	
	
	
//	@RequestMapping("delete{id}")
//	public boolean delete(@PathVariable("id") int id) {
//		System.out.println("in delete");
//		for (Customer customer : list) {
//			if (customer.getId() == id) {
//				list.remove(customer);
//				return true;
//			}
//		}
//		return false;
//	}
//	@RequestMapping("logged/{username}and(password)")
//	public int login(@PathVariable("username") String username, @PathVariable("password") String password) {
//		System.out.println("loged in");
//		if (username.equals("abc") && password.equals("123")) 
//		  return 1; // login
//		return 0; // no login
//	
//	}

}

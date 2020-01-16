package com.johnabbott.corebanking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.johnabbott.corebanking.model.Account;
import com.johnabbott.corebanking.model.Customer;
import com.johnabbott.corebanking.service.AccountService;
import com.johnabbott.corebanking.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService service;

	@Autowired
	AccountService accountService;

	@RequestMapping(value = "/getcustomers", method = RequestMethod.GET)
	public ModelAndView getCustomersList() {

		List<Customer> customers = service.getCustomers();

		ModelAndView mv = new ModelAndView("customer-list");
		mv.addObject("customerList", customers);

		return mv;
	}

	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public ModelAndView getStudent(@PathVariable("id") int customerId) {
		ModelAndView modelView = new ModelAndView("customer");
		modelView.addObject("customerId", customerId);

		return modelView;
	}

	@RequestMapping(value = "addcustomer")
	public ModelAndView addCustomer() {
		ModelAndView mv = new ModelAndView("add-customer");
		mv.addObject("customer", new Customer());
		return mv;
	}

	@RequestMapping(value = "saveCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		if (service.addCustomer(customer))
			return "redirect:/getcustomers";
		else {
			return "ErrorPage";
		}
	}

	@RequestMapping(value = "deletecustomer")
	public ModelAndView deleteCustomer(@RequestParam("customerId") int customerId) {
		List<Account> accounts = accountService.getAccountsByCustomerId(customerId);
		ModelAndView mv = new ModelAndView("customer-list");

		if (accounts == null) {
			if (service.deleteCustomer(customerId)) {
				List<Customer> customers = service.getCustomers();
				mv.addObject("customerList", customers);
				mv.addObject("errorMsg", ("Succeeded to delete the customer with Id equal " +customerId));
			} else {
				mv.addObject("errorMsg", ("I am sorry. error occurs!"));
			}
		} else {
			List<Customer> customers = service.getCustomers();
			mv.addObject("customerList", customers);
			mv.addObject("errorMsg",
					("When I have any account, you can not delete me. My customer Id is equal to " + customerId));
		}
		return mv;

	}

	@RequestMapping(value = "editcustomer")
	public ModelAndView editCustomer(@RequestParam("customerId") int customerId) {
		ModelAndView mv = new ModelAndView("update-customer");
		Customer fetchedCustomer = service.getCustomerById(customerId);
		mv.addObject("editedCustomer", fetchedCustomer);
		return mv;
	}

	@RequestMapping(value = "updatecustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {
		if (service.updateCustomer(customer)) {
			return "redirect:/getcustomers";
		} else {
			return "ErrorPage";
		}
	}

}

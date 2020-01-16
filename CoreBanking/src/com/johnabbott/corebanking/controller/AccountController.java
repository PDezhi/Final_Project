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

@Controller
public class AccountController {

	@Autowired
	AccountService service;

	@RequestMapping(value = "/getaccounts", method = RequestMethod.GET)
	public ModelAndView getAccountsList() {

		List<Account> accounts = service.getAccounts();

		ModelAndView mv = new ModelAndView("all-accounts-list");
		mv.addObject("accountList", accounts);

		return mv;
	}

	@RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
	public ModelAndView getAccount(@PathVariable("id") int accountId) {
		ModelAndView modelView = new ModelAndView("account");
		modelView.addObject("accountId", accountId);

		return modelView;
	}

	@RequestMapping(value = "openaccount")
	public ModelAndView addAccount(@RequestParam("customerId") int customerId) {
		ModelAndView mv = new ModelAndView("add-account");
		mv.addObject("account", new Account(new Customer(customerId)));
		return mv;
	}

	@RequestMapping(value = "saveAccount", method = RequestMethod.POST)
	public ModelAndView saveAccount(@ModelAttribute("account") Account account) {
		service.openAccount(account);
		int customerId = account.getCustomer().getCustomerId();
		List<Account> accounts = service.getAccountsByCustomerId(customerId);

		ModelAndView modelView = new ModelAndView("account-list");
		modelView.addObject("customerId", customerId);
		modelView.addObject("accountList", accounts);

		return modelView;
	}

	@RequestMapping(value = "closeaccount")
	public ModelAndView deleteAccount(@RequestParam("accountId") int accountId) {
		Account account = service.getAccountById(accountId);
		if (service.closeAccount(accountId)) {
			List<Account> accounts = service.getAccountsByCustomerId(account.getCustomer().getCustomerId());
			ModelAndView modelView = new ModelAndView("account-list");
			modelView.addObject("customerId", account.getCustomer().getCustomerId());
			modelView.addObject("accountList", accounts);
			return modelView;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "editaccount")
	public ModelAndView editAccount(@RequestParam("accountId") int accountId) {
		ModelAndView mv = new ModelAndView("update-account");
		Account fetchedAccount = service.getAccountById(accountId);
		mv.addObject("editedAccount", fetchedAccount);
		return mv;
	}

	@RequestMapping(value = "getaccountsbycustomerid")
	public ModelAndView getAccountsByCustomerId(@RequestParam("customerId") int customerId) {
		List<Account> accounts = service.getAccountsByCustomerId(customerId);

		ModelAndView modelView = new ModelAndView("account-list");
		modelView.addObject("customerId", customerId);
		modelView.addObject("accountList", accounts);

		return modelView;
	}

	@RequestMapping(value = "updateaccount")
	public ModelAndView updateAccount(@ModelAttribute("account") Account account) {
		if (service.updateAccount(account)) {
			List<Account> accounts = service.getAccountsByCustomerId(account.getCustomer().getCustomerId());
			ModelAndView modelView = new ModelAndView("account-list");
			modelView.addObject("customerId", account.getCustomer().getCustomerId());
			modelView.addObject("accountList", accounts);
			return modelView;
		} else {
			return null;
		}
	}

}

package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class for screen display and DB integration
 */
@Controller
public class RequestProc6 {

	/**
	 * Instantiate the CustomerRepository class.
	 */
	@Autowired
	CustomerRepository cusRepository;

	/**
	 * Function for initial screen display
	 * @return "index6" Return index6.html
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		// Obtain all customer information registered in the DB
		List<Customer> customerList = cusRepository.findAll();
		model.addAttribute("customerList", customerList);

		return "index6";
	}

	/**
	 * Function for displaying additional screen of customer information
	 * @param model Model for input field
	 * @return "addition" Return addition.html
	 */
	@RequestMapping(value = "/addition", method = RequestMethod.GET)
	public String customerAddition(Model model) {

		// Creates an object to store the characters entered
		model.addAttribute("customer", new Customer());

		return "addition";
	}

	/**
	 * Function to register customer information to DB
	 * @param cusAdd An object containing customer information
	 * @return "redirect:/" Return to the root index6.html
	 */
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute Customer cusInfo) {

		// Registering customer information to DB
		cusRepository.save(cusInfo);

		return "redirect:/";
	}
}

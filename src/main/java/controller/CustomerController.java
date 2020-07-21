package main.java.controller;

import main.java.entity.Customer;
import main.java.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Customer> listCustomer = customerService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listCustomer", listCustomer);
		return mav;
	}
	
	@RequestMapping("/new_customer")
	public ModelAndView newCustomerForm(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("new_customer");
		Customer customer = new Customer();
		model.put("customer", customer);
		return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveCustomer(@ModelAttribute("customer") Customer customer, HttpServletResponse httpResponse) throws IOException {
		customerService.save(customer);
		httpResponse.sendRedirect("/");
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_customer");
		Customer customer = customerService.get(id);
		mav.addObject("customer", customer);
		return mav;
	}
	
	@RequestMapping("/delete")
	public void deleteCustomerForm(@RequestParam long id, HttpServletResponse httpResponse ) throws IOException {
		customerService.delete(id);
		httpResponse.sendRedirect("/");
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Customer> result = customerService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		return mav;		
	}	
}

package main.java.controller;

import main.java.entity.Order;
import main.java.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/3")
	public ModelAndView home() {
		List<Order> listOrder = orderService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listOrder", listOrder);
		return mav;
	}
	
	@RequestMapping("/new3")
	public String newOrderForm(Map<String, Object> model) {
		Order order = new Order();
		model.put("order", order);
		return "new_order";
	}
	
	@RequestMapping(value = "/save3", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order) {
		orderService.save(order);
		return "redirect:/";
	}
	
	@RequestMapping("/edit3")
	public ModelAndView editOrderForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_order");
		Order order = orderService.get(id);
		mav.addObject("order", order);
		
		return mav;
	}
	
	@RequestMapping("/delete3")
	public String deleteOrderForm(@RequestParam long id) {
		orderService.delete(id);
		return "redirect:/";		
	}

}

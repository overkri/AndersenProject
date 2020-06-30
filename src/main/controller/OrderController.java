package main.controller;

import main.entity.Order;
import main.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Order> listOrder = orderService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listOrder", listOrder);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newOrderForm(Map<String, Object> model) {
		Order order = new Order();
		model.put("order", order);
		return "new_order";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveOrder(@ModelAttribute("order") Order order) {
		orderService.save(order);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editOrderForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_order");
		Order order = orderService.get(id);
		mav.addObject("order", order);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteOrderForm(@RequestParam long id) {
		orderService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Order> result = orderService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}

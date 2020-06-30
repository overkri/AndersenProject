package main.controller;

import main.entity.Hotel;
import main.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Hotel> listHotel = hotelService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listHotel", listHotel);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newHotelForm(Map<String, Object> model) {
		Hotel hotel = new Hotel();
		model.put("hotel", hotel);
		return "new_hotel";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveHotel(@ModelAttribute("hotel") Hotel hotel) {
		hotelService.save(hotel);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editHotelForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_hotel");
		Hotel hotel = hotelService.get(id);
		mav.addObject("hotel", hotel);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteHotelForm(@RequestParam long id) {
		hotelService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Hotel> result = hotelService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}

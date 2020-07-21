package main.java.controller;

import main.java.entity.Tour;
import main.java.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class TourController {

	@Autowired
	private TourService tourService;
	
	@RequestMapping("/1")
	public ModelAndView home() {
		List<Tour> listTour = tourService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listTour", listTour);
		return mav;
	}
	
	@RequestMapping("/new1")
	public String newTourForm(Map<String, Object> model) {
		Tour tour = new Tour();
		model.put("tour", tour);
		return "new_tour";
	}
	
	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public String saveTour(@ModelAttribute("tour") Tour tour) {
		tourService.save(tour);
		return "redirect:/";
	}
	
	@RequestMapping("/edit1")
	public ModelAndView editTourForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("tour");
		Tour tour = tourService.get(id);
		mav.addObject("tour", tour);
		
		return mav;
	}
	
	@RequestMapping("/delete1")
	public String deleteTourForm(@RequestParam long id) {
		tourService.delete(id);
		return "redirect:/";		
	}
}

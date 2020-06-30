package main.controller;

import main.entity.Tour;
import main.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class TourController {

	@Autowired
	private TourService tourService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Tour> listTour = tourService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listTour", listTour);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newTourForm(Map<String, Object> model) {
		Tour tour = new Tour();
		model.put("tour", tour);
		return "new_tour";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTour(@ModelAttribute("tour") Tour tour) {
		tourService.save(tour);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editTourForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("tour");
		Tour tour = tourService.get(id);
		mav.addObject("tour", tour);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteTourForm(@RequestParam long id) {
		tourService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Tour> result = tourService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}

package main.controller;

import main.entity.Country;
import main.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class CountryController {

	@Autowired
	private CountryService countryService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Country> listCountry = countryService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listCountry", listCountry);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newCountryForm(Map<String, Object> model) {
		Country country = new Country();
		model.put("country", country);
		return "new_country";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("customer") Country country) {
		countryService.save(country);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCountryForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_country");
		Country country = countryService.get(id);
		mav.addObject("country", country);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteCountryForm(@RequestParam long id) {
		countryService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Country> result = countryService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}

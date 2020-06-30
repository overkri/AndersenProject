package main.controller;

import main.entity.Review;
import main.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		List<Review> listReview = reviewService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listReview", listReview);
		return mav;
	}
	
	@RequestMapping("/new")
	public String newReviewForm(Map<String, Object> model) {
		Review review = new Review();
		model.put("review", review);
		return "new_review";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveReview(@ModelAttribute("review") Review review) {
		reviewService.save(review);
		return "redirect:/";
	}
	
	@RequestMapping("/edit")
	public ModelAndView editReviewForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_review");
		Review review = reviewService.get(id);
		mav.addObject("review", review);
		
		return mav;
	}
	
	@RequestMapping("/delete")
	public String deleteReviewForm(@RequestParam long id) {
		reviewService.delete(id);
		return "redirect:/";		
	}
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		List<Review> result = reviewService.search(keyword);
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("result", result);
		
		return mav;		
	}	
}

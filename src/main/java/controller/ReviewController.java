package main.java.controller;

import main.java.entity.Review;
import main.java.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/2")
	public ModelAndView home() {
		List<Review> listReview = reviewService.listAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("listReview", listReview);
		return mav;
	}
	
	@RequestMapping("/new2")
	public String newReviewForm(Map<String, Object> model) {
		Review review = new Review();
		model.put("review", review);
		return "new_review";
	}
	
	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String saveReview(@ModelAttribute("review") Review review) {
		reviewService.save(review);
		return "redirect:/";
	}
	
	@RequestMapping("/edit2")
	public ModelAndView editReviewForm(@RequestParam long id) {
		ModelAndView mav = new ModelAndView("edit_review");
		Review review = reviewService.get(id);
		mav.addObject("review", review);
		
		return mav;
	}
	
	@RequestMapping("/delete2")
	public String deleteReviewForm(@RequestParam long id) {
		reviewService.delete(id);
		return "redirect:/";		
	}

}

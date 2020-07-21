package main.java.service;

import java.util.List;

import main.java.exceptions.IdNotFoundException;
import main.java.repository.ReviewRepository;
import main.java.entity.Review;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {

	private ReviewRepository repo;

	public ReviewService(ReviewRepository repo) {
		this.repo = repo;
	}

	public void save(Review review) {
		repo.save(review);
	}
	
	public List<Review> listAll() {
		return (List<Review>) repo.findAll();
	}
	
	public Review get(Long id) {
		return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Not found" + id));
	};
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}

package main.service;

import java.util.List;

import main.exceptions.IdNotFoundException;
import main.repository.ReviewRepository;
import main.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
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

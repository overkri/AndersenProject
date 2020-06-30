package main.service;

import java.util.List;

import main.repository.ReviewRepository;
import main.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReviewService {
	@Autowired
	ReviewRepository repo;
	
	public void save(Review review) {
		repo.save(review);
	}
	
	public List<Review> listAll() {
		return (List<Review>) repo.findAll();
	}
	
	public Review get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Review> search(String keyword) {
		return repo.search(keyword);
	}
}

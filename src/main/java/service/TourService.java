package main.java.service;

import java.util.List;

import main.java.exceptions.IdNotFoundException;
import main.java.repository.TourRepository;
import main.java.entity.Tour;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TourService {

	private TourRepository repo;

	public TourService(TourRepository repo) {
		this.repo = repo;
	}

	public void save(Tour tour) {
		repo.save(tour);
	}
	
	public List<Tour> listAll() {
		return (List<Tour>) repo.findAll();
	}
	
	public Tour get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.findById(id).orElseThrow(() -> new IdNotFoundException("Not found" + id));
	}

}

package main.service;

import java.util.List;

import main.exceptions.IdNotFoundException;
import main.repository.TourRepository;
import main.entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
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

package main.java.service;

import java.util.List;

import main.java.exceptions.IdNotFoundException;
import main.java.repository.HotelRepository;
import main.java.entity.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HotelService {

	private HotelRepository repo;

	public HotelService(HotelRepository repo) {
		this.repo = repo;
	}

	public void save(Hotel hotel) {
		repo.save(hotel);
	}
	
	public List<Hotel> listAll() {
		return (List<Hotel>) repo.findAll();
	}
	
	public Hotel get(Long id) {
		return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Not found" + id));
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Hotel> search(String keyword) {
		return repo.search(keyword);
	}
}

package main.service;

import java.util.List;

import main.exceptions.IdNotFoundException;
import main.repository.HotelRepository;
import main.entity.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
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

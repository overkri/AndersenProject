package main.service;

import java.util.List;

import main.repository.CountryRepository;
import main.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {
	@Autowired
	private CountryRepository repo;
	
	public void save(Country country) {
		repo.save(country);
	}
	
	public List<Country> listAll() {
		return (List<Country>) repo.findAll();
	}
	
	public Country get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Country> search(String keyword) {
		return repo.search(keyword);
	}
}

package main.service;

import java.util.List;

import main.exceptions.IdNotFoundException;
import main.repository.CountryRepository;
import main.repository.CustomerRepository;
import main.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

	public void save(Customer customer) {
		repo.save(customer);
	}
	
	public List<Customer> listAll() {
		return (List<Customer>) repo.findAll();
	}
	
	public Customer get(Long id) {
		return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Not found" + id));
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Customer> search(String keyword) {
		return repo.search(keyword);
	}
}

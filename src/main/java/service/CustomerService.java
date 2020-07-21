package main.java.service;

import java.util.List;

import main.java.exceptions.IdNotFoundException;
import main.java.repository.CustomerRepository;
import main.java.entity.Customer;
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

package main.service;

import java.util.List;

import main.repository.OrderRepository;
import main.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {
	@Autowired
	OrderRepository repo;
	
	public void save(Order order) {
		repo.save(order);
	}
	
	public List<Order> listAll() {
		return (List<Order>) repo.findAll();
	}
	
	public Order get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
	public List<Order> search(String keyword) {
		return repo.search(keyword);
	}
}

package main.java.service;

import java.util.List;

import main.java.exceptions.IdNotFoundException;
import main.java.repository.OrderRepository;
import main.java.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderService {

	private OrderRepository repo;

	public OrderService(OrderRepository repo) {
		this.repo = repo;
	}

	public void save(Order order) {
		repo.save(order);
	}
	
	public List<Order> listAll() {
		return (List<Order>) repo.findAll();
	}
	
	public Order get(Long id) {
		return repo.findById(id).orElseThrow(() -> new IdNotFoundException("Not found" + id));
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

}

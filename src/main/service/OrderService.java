package main.service;

import java.util.List;

import main.exceptions.IdNotFoundException;
import main.repository.OrderRepository;
import main.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
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

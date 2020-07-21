package main.java.repository;

import main.java.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

}

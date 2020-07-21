package main.java.repository;

import main.java.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
	
	@Query(value = "SELECT c FROM Customer c WHERE c.name LIKE %:keyword% or c.surname LIKE %:keyword% or c.email LIKE %:keyword%  ")
	List<Customer> search(@Param("keyword") String keyword);

	
}

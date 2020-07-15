package main.repository;

import main.entity.Hotel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {
	
	@Query(value = "SELECT c FROM Hotel c WHERE c.name LIKE %:keyword% or c.address LIKE %:keyword% ")
	List<Hotel> search(@Param("keyword") String keyword);
}

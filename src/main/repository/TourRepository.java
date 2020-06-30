package main.repository;

import main.entity.Tour;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends PagingAndSortingRepository<Tour, Long> {
	
	@Query(value = "SELECT c FROM Hotel c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'"
			+ " OR c.surname LIKE '%' || :keyword || '%'")
	List<Tour> search(@Param("keyword") String keyword);
}

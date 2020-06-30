package main.repository;

import main.entity.Review;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {
	
	@Query(value = "SELECT c FROM Hotel c WHERE c.name LIKE '%' || :keyword || '%'"
			+ " OR c.email LIKE '%' || :keyword || '%'"
			+ " OR c.surname LIKE '%' || :keyword || '%'")
	List<Review> search(@Param("keyword") String keyword);
}

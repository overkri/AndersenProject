package main.java.repository;

import main.java.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
	
	@Query(value = "SELECT c FROM Country c WHERE c.name LIKE %:keyword% ")
	List<Country> search(@Param("keyword") String keyword);
}

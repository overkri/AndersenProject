package main.java.repository;

import main.java.entity.Tour;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TourRepository extends PagingAndSortingRepository<Tour, Long> {

}

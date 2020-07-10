package main.repository;

import main.entity.Tour;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TourRepository extends PagingAndSortingRepository<Tour, Long> {

}

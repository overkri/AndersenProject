package main.java.repository;

import main.java.entity.Review;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReviewRepository extends PagingAndSortingRepository<Review, Long> {

}

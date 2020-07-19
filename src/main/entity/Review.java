package main.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idReview", nullable = false)
	private Long id;

	@Column(name = "ReviewMessage", nullable = false)
	private String message;

	@Column(name = "ReviewDate", nullable = false)
	private Date date;

	@Column(name = "ReviewScore", nullable = false)
	private int score;

	@ManyToOne
	@JoinColumn(name = "Customer_id_Customer")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "Tour_idTour")
	private Tour tour;

	public Review() {
	}

	protected Review(String message, Date date, int score, Customer customer, Tour tour) {
		this.message = message;
		this.date = date;
		this.score = score;
		this.customer = customer;
		this.tour = tour;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}

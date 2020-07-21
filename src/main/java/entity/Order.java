package main.java.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrder", nullable = false)
    private Long id;

    @Column(name = "OrderStart", nullable = false)
    private Date start;

    @Column(name = "OrderEnd", nullable = false)
    private Date end;

    @ManyToOne
    @JoinColumn(name = "countries_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "Hotel_idHotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "Customer_id_Customer")
    private Customer customer;

    public Order() {
    }

    protected Order(Date start, Date end, Country country, Customer customer, Hotel hotel) {
        this.start = start;
        this.end = end;
        this.customer = customer;
        this.country = country;
        this.hotel = hotel;
    }

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return start;
    }

    public void setStartDate(Date start) {
        this.start = start;
    }

    public Date getEndDate() {
        return end;
    }

    public void setEndDate(Date end) {
        this.end = end;
    }

}

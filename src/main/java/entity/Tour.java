package main.java.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Tour")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTour", nullable = false)
    private Long id;

    @Column(name = "TourStartTime", nullable = false)
    private Date start;

    @Column(name = "TourEndTime", nullable = false)
    private Date end;

    @Column(name = "Tourcost", nullable = false)
    private int cost;

    @ManyToOne
    @JoinColumn(name = "countries_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "Hotel_idHotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "Customer_id_Customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Order_idOrder")
    private Order order;

    public Tour() {
    }

    protected Tour(Date start, Date end, int cost, Country country, Customer customer, Hotel hotel, Order order) {
        this.start = start;
        this.end = end;
        this.cost = cost;
		this.customer = customer;
		this.country = country;
		this.hotel = hotel;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}

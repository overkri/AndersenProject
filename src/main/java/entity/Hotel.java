package main.java.entity;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idHotel", nullable = false)
	private Long id;

	@Column(name = "Hotelname", nullable = false)
	private String name;

	@Column(name = "HotelAddress", nullable = false)
	private String address;

	@ManyToOne
	@JoinColumn(name = "countries_id")
	private Country country;

	public Hotel() {
	}

	protected Hotel(String name, String address, Country country) {
		this.name = name;
		this.address = address;
		this.country = country;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

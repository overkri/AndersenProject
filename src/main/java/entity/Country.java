package main.java.entity;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", nullable = false)
	private Long id;

	@Column(name = "Name")
	private String name;


	public Country() {
	}

	protected Country(String name) {
		this.name = name;
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

}

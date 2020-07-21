package main.java.entity;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Customer", nullable = false)
	private Long id;

	@Column(name = "Customer_name")
	private String name;

	@Column(name = "Customer_surname")
	private String email;

	@Column(name = "Customer_email")
	private String surname;

	public Customer() {
	}

	protected Customer(String name, String email, String surname) {
		this.name = name;
		this.email = email;
		this.surname = surname;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}

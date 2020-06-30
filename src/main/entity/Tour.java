package main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Date start;
	private Date end;
	private int cost;

	public Tour() {
	}

	protected Tour(Date start, Date end, int cost) {
		this.start = start;
		this.end = end;
		this.cost = cost;
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

package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_bus")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_bus_seq")
	@SequenceGenerator(sequenceName = "bus_seq", allocationSize = 1, name = "my_bus_seq")
	@Column(name = "BUS_ID")
	private int busId;

	@Column(name = "BUS_NAME")
	private String busName;

	@Column(name = "BUS_TYPE")
	private String busType;

	@Column(name = "NO_OF_Seats")
	private int noOfseats;

	@ManyToOne
	@JoinColumn(name = "ROUTE_ID")
	private Route route;

	@OneToMany(mappedBy = "bus", cascade = CascadeType.MERGE)
	private List<Review> reviews;

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public int getNoOfseats() {
		return noOfseats;
	}

	public void setNoOfseats(int noOfseats) {
		this.noOfseats = noOfseats;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

}

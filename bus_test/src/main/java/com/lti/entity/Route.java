package com.lti.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_route")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_route_seq")
	@SequenceGenerator(sequenceName = "route_seq", allocationSize = 1, name = "my_route_seq")
	@Column(name = "route_id")
	private int id;

	@Column(name = "source")
	private String source;

	@Column(name = "destination")
	private String destination;

	@Column(name = "fare")
	private double fare;

	@Column(name = "duration")
	private String duration;

	@Column(name = "date_of_depature")
	private LocalDateTime dateOfDepature;

	@Column(name = "date_of_arrival")
	private LocalDateTime dateOfArrival;

	@Column(name = "seat_aval")
	private int seatAvailable;

	@OneToMany(mappedBy = "route", cascade = CascadeType.MERGE)
	private List<Bus> buses;

	@OneToMany(mappedBy = "route", cascade = CascadeType.MERGE)
	private List<Booking> bookings;

	@OneToMany(mappedBy = "route", cascade = CascadeType.MERGE)
	private List<Stop> stops;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LocalDateTime getDateOfDepature() {
		return dateOfDepature;
	}

	public void setDateOfDepature(LocalDateTime dateOfDepature) {
		this.dateOfDepature = dateOfDepature;
	}

	public LocalDateTime getDateOfArrival() {
		return dateOfArrival;
	}

	public void setDateOfArrival(LocalDateTime dateOfArrival) {
		this.dateOfArrival = dateOfArrival;
	}

	public int getSeatAvailable() {
		return seatAvailable;
	}

	public void setSeatAvailable(int seatAvailable) {
		this.seatAvailable = seatAvailable;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Stop> getStops() {
		return stops;
	}

	public void setStops(List<Stop> stops) {
		this.stops = stops;
	}

}

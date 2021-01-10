package com.lti.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_stops")
public class Stop {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_stop_seq")
	@SequenceGenerator(sequenceName = "stop_seq", allocationSize = 1, name = "my_stop_seq")
	@Column(name = "stop_id")
	private int stopId;

	@Column(name = "city")
	private String city;

	@Column(name = "stop")
	private String stop;

	@Column(name = "time")
	private LocalDateTime time;

	@ManyToOne
	@JoinColumn(name = "route_id")
	private Route route;

	public int getStopId() {
		return stopId;
	}

	public void setStopId(int stopId) {
		this.stopId = stopId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStop() {
		return stop;
	}

	public void setStop(String stop) {
		this.stop = stop;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

}

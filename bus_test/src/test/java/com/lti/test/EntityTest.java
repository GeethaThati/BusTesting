package com.lti.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.Booking;
import com.lti.entity.Bus;
import com.lti.entity.Passenger;
import com.lti.entity.Payment;
import com.lti.entity.Review;
import com.lti.entity.Route;
import com.lti.entity.Stop;
import com.lti.entity.Users;

public class EntityTest {
	
	@Test
	public void addUser() {
		Users u = new Users();
		u.setFirstName("Pavithra");
		u.setLastName("R");
		u.setGender("Female");
		u.setEmail("pavithra@gmail.com");
		u.setPassword("pavi123");
		u.setContact(7894000230L);
		u.setDob(LocalDate.of(1999, 3, 27));
		u.setAuthorized(true);
		u.setWallet(66);
		
		GenericDao dao = new GenericDao();
		dao.save(u);
	}
	
	@Test
	public void testRoute() {
		Route r = new Route();
		r.setSource("Chennai");
		r.setDestination("Hyderabad");
		r.setFare(590);
		r.setDuration("10 hours");
		r.setDateOfDepature(LocalDateTime.of(2021, 1, 15, 21, 15));
		r.setDateOfArrival(LocalDateTime.of(2021, 1, 16, 7, 15));
		r.setSeatAvailable(42);
		
		GenericDao dao = new GenericDao();
		dao.save(r);
		
	}
	
	@Test
	public void addBus() {
		GenericDao dao = new GenericDao();
		Route r = (Route) dao.fetch(Route.class,4412);
		
		Bus b = new Bus();
		b.setBusName("Tata");
		b.setBusType("Ac");
		b.setNoOfseats(44);
		b.setRoute(r);
		
		Bus b1 = new Bus();
		b1.setBusName("Vajra");
		b1.setBusType("Non-Ac");
		b1.setNoOfseats(44);
		b1.setRoute(r);
		
		List<Bus> pass = new ArrayList<Bus>();
		pass.add(b1);
		pass.add(b);
		
		r.setBuses(pass);
		
		dao.save(r);
		
	}
	
	
	@Test
	public void addBookingToRoute() {
		GenericDao dao = new GenericDao();
		Route r=(Route) dao.fetch(Route.class, 4412);
		Booking book = new Booking();
		book.setBoarding("Egmore,Chennai");
		book.setDroping("Kukatpally,Hyderabad");
		book.setStatus("Confirm");
		book.setPaidDate(LocalDateTime.now());
		book.setAmount(1770);
		book.setRoute(r);
		Users u = (Users) dao.fetch(Users.class, 22);
		book.setUser(u);
		dao.save(book);
	
	}
	
	@Test
	public void addPassenger() {
		GenericDao dao = new GenericDao();
		Booking b = (Booking) dao.fetch(Booking.class, 30033);
		
		Passenger p = new Passenger();
		p.setName("Pooja");
		p.setAge(18);
		p.setSeatNo(10);
		p.setGender("Female");
		p.setBooking(b);
		
		Passenger p1 = new Passenger();
		p1.setName("sony");
		p1.setAge(21);
		p1.setSeatNo(23);
		p1.setGender("Female");
		p1.setBooking(b);
		
		Passenger p2 = new Passenger();
		p2.setName("sunny");
		p2.setAge(25);
		p2.setSeatNo(40);
		p2.setGender("male");
		p2.setBooking(b);
		
		List<Passenger> pass = new ArrayList<Passenger>();
		pass.add(p1);
		pass.add(p);
		pass.add(p2);
		
		b.setPassengers(pass);
		
		dao.save(b);
		
	}
	
	@Test
	public void payment() {
		GenericDao dao = new GenericDao();
		Users u = (Users) dao.fetch(Users.class, 22);
		Booking b = (Booking) dao.fetch(Booking.class, 30033);

		Payment p = new Payment();
		p.setPaymenttype("Credit Card");
		p.setStatus("Paid");
		p.setAmountPaid(1770);
		p.setPaymentdate(LocalDate.now());
		p.setBooking(b);
		p.setUser(u);
		
		dao.save(p);
	}
	
	@Test
	public void addReview() {
		GenericDao dao = new GenericDao();
		Users u = (Users) dao.fetch(Users.class, 20);
		Bus b= (Bus) dao.fetch(Bus.class, 230);
		
		Review r= new Review();
		r.setRating(4);
		r.setBus(b);
		r.setUser(u);
		
		dao.save(r);
	}
	
	@Test
	public void addStops() {
		GenericDao dao = new GenericDao();
		Route r =  (Route) dao.fetch(Route.class, 4412);
		
		Stop s = new Stop();
		s.setStop("Adyar");
		s.setCity("Chennai");
		s.setTime(LocalDateTime.of(2021, 1, 15, 22, 15));
		s.setRoute(r);
		
		Stop s2 = new Stop();
		s2.setStop("Egmore");
		s2.setCity("Chennai");
		s2.setTime(LocalDateTime.of(2021, 1, 15, 21, 30));
		s2.setRoute(r);
		
		Stop s1 = new Stop();
		s1.setStop("Kukatpally");
		s1.setCity("Hyderabad");
		s1.setTime(LocalDateTime.of(2021, 1, 15, 6, 40));
		s1.setRoute(r);
		
		Stop s3 = new Stop();
		s3.setStop("Lingampally");
		s3.setCity("Hyderabad");
		s3.setTime(LocalDateTime.of(2021, 1, 15, 7, 00));
		s3.setRoute(r);
		
		List<Stop> pass = new ArrayList<Stop>();
		pass.add(s1);
		pass.add(s);
		pass.add(s2);
		pass.add(s3);
		
		r.setStops(pass);
		
		
		dao.save(r);
		
	}
}

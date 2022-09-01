package com.lti.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Flight_Details")
public class Flight {

	@Id
	private int flight_id;
	private String flightName;
	private int capacity;
	private double economyPrice;
	private double businessPrice;
	private String departureTime;
	private String arrivalTime;
	private String source;
	private String destination;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JoinColumn(name = "flight_id")
	@OneToMany( cascade = CascadeType.ALL,targetEntity=BookingDetails.class)
	private List<BookingDetails> bookings;

	

	public Flight(int flight_id, String flightName, int capacity, double economyPrice, double businessPrice,
			String departureTime, String arrivalTime, String source, String destination, String type) {
		super();
		this.flight_id = flight_id;
		this.flightName = flightName;
		this.capacity = capacity;
		this.economyPrice = economyPrice;
		this.businessPrice = businessPrice;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.source = source;
		this.destination = destination;
		this.type = type;
	}

	public Flight() {
	}

	public List<BookingDetails> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDetails> bookings) {
		this.bookings = bookings;
	}

	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(double economyPrice) {
		this.economyPrice = economyPrice;
	}

	public double getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(double businessPrice) {
		this.businessPrice = businessPrice;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
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

	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flightName=" + flightName + ", capacity=" + capacity
				+ ", economyPrice=" + economyPrice + ", businessPrice=" + businessPrice + ", departureTime="
				+ departureTime + ", arrivalTime=" + arrivalTime + ", source=" + source + ", destination=" + destination
				+ ", type=" + type + "]";
	}

	

	

}

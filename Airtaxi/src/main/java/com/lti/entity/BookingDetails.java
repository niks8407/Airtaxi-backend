package com.lti.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "Booking_Details")
public class BookingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "Booking_ID_Seq", allocationSize = 23456)
	private int booking_id;
	private String passengerName;
	private String flightName;
	private String email_Id;
	private String age;
	private Date bookingDate;
	private String bookingType;
	private String seatNo;
	private String amount;
	private String source;
	private String destination;
	private String arrivalTime;
	private String departureTime;
	
	
	
	
	
public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
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

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public List<PassengerDetails> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<PassengerDetails> passenger) {
		this.passenger = passenger;
	}

	//	@ManyToOne
//	private Flight flight;
//	
	@ManyToOne
	private UserDetails user;
	
	@JoinColumn(name = "booking_id")
	@OneToMany( cascade = CascadeType.ALL,targetEntity=PassengerDetails.class)
	private List<PassengerDetails> passenger;
//	
//
//	//@JoinColumn(name = "booking_id")
//	@JoinColumn(name = "ticket_id")
//	@OneToOne(fetch = FetchType.LAZY)
//	private Ticket ticket;
//	
//	
//
//	public Ticket getTicket() {
//		return ticket;
//	}
//
//	public void setTicket(Ticket ticket) {
//		this.ticket = ticket;
//	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
	}

//	public Flight getFlight() {
//		return flight;
//	}
//
//	public void setFlight(Flight flight) {
//		this.flight = flight;
//	}

	public Date getBookingDate() {
		return bookingDate;
	}


	public BookingDetails() {
		//this.flight=flight;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}


	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBookingType() {
		return bookingType;
	}

	public void setBookingType(String bookingType) {
		this.bookingType = bookingType;
	}

	public BookingDetails(int booking_id, String passengerName, String flightName, String email_Id, String age,
			Date bookingDate, String bookingType, String seatNo, String amount, String source, String destination,
			String arrivalTime, String departureTime) {
		super();
		this.booking_id = booking_id;
		this.passengerName = passengerName;
		this.flightName = flightName;
		this.email_Id = email_Id;
		this.age = age;
		this.bookingDate = bookingDate;
		this.bookingType = bookingType;
		this.seatNo = seatNo;
		this.amount = amount;
		this.source = source;
		this.destination = destination;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "BookingDetails [booking_id=" + booking_id + ", passengerName=" + passengerName + ", flightName="
				+ flightName + ", email_Id=" + email_Id + ", age=" + age + ", bookingDate=" + bookingDate
				+ ", bookingType=" + bookingType + ", seatNo=" + seatNo + ", amount=" + amount + ", source=" + source
				+ ", Destination=" + destination + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime
				+ "]";
	}



	
	

}

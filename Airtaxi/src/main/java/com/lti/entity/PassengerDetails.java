package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Passenger_Details")
public class PassengerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "Passenger_ID_Seq", allocationSize = 1)
	private int passengerId;
	
	private String passengerName;
	private int age;
	
	@ManyToOne
	private BookingDetails booking;
	
	
	
	public PassengerDetails() {
	}
	public PassengerDetails(int passengerId, String passengerName, int age) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.age = age;
	}
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "passengeDetails [passengerId=" + passengerId + ", passengerName=" + passengerName + ", age=" + age
				+ "]";
	}
	
	
	
	
	
	
	
	
	

}

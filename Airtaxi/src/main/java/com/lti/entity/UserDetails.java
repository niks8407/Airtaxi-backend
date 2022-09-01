package com.lti.entity;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="User_Details")
public class UserDetails {
	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_Sequence")
//	@SequenceGenerator(name = "pid_Sequence", sequenceName = "PID_SEQ", allocationSize = 1)
	private String email_Id;
	private String title;
	private String firstName;
	private String lastName;
	
//	@Column(nullable = false, unique = true, length = 45)
//	private String email_Id;
	
	private String password;
	private String mobile_No;
	private String dob;
	
	@JoinColumn(name = "profile_id")
	@OneToMany( cascade = CascadeType.ALL,targetEntity=BookingDetails.class)
	private List<BookingDetails> bookings;
	

	public UserDetails( String title, String firstName, String lastName, String email_Id,
			String password, String mobile_No, String dob) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email_Id = email_Id;
		this.password = password;
		this.mobile_No = mobile_No;
		this.dob = dob;
	}
	
	public UserDetails() {
		
	}

	public List<BookingDetails> getBookings() {
		return bookings;
	}
	public void setBookings(List<BookingDetails> bookings) {
		this.bookings = bookings;
	}
//	public long getProfile_id() {
//		return profile_id;
//	}
//	public void setProfile_id(int profile_id) {
//		this.profile_id = profile_id;
//	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail_Id() {
		return email_Id;
	}
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile_No() {
		return mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		this.mobile_No = mobile_No;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return "UserDetails [ title=" + title + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email_Id=" + email_Id + ", password=" + password + ", mobile_No=" + mobile_No + ", dob="
				+ dob + "]";
	}
	
	
	
}

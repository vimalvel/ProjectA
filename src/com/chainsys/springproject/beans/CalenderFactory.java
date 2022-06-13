package com.chainsys.springproject.beans;

public class CalenderFactory {
	// the factory method - is not static method
	public Calender createCalender() {
		// the Calender constructor is default access modifier so, can be called here
		return new Calender();
	}
	
	 public Appointments createAppointments() {
		 return new Appointments();
	 }

}

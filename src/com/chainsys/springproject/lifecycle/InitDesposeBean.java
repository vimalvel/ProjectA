package com.chainsys.springproject.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.config.BeanPostProcessor; // refer aop

public class InitDesposeBean implements DisposableBean, InitializingBean {
private String City;
private long pinCode;
public String getCity() {
	return City;
}

public void setCity(String city) {
	City = city;
}

public long getPinCode() {
	return pinCode;
}

public void setPinCode(long pincode) {
	this.pinCode = pincode;
}

	@Override
	public void afterPropertiesSet() throws Exception {
System.out.println("AfterProperties Called");
	}

	@Override
	public void destroy() throws Exception {
System.out.println("Destroy method Called");
	}

	public InitDesposeBean() {
		System.out.println("InitDesposeBean");
	}
	// after constructor

	public void setUp() {
		System.out.println("starting...");
	}

	public void close() {
		System.out.println("closing...");
	}
	public void print() {
		System.out.println("Print");
	}

	

}

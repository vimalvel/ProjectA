package com.chainsys.springproject.test;

import com.chainsys.springproject.appconfig.AppConfig;
import org.springframework.context.ApplicationContext;//parent
import org.springframework.context.annotation.AnnotationConfigApplicationContext;//child
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.chainsys.springproject.beans.Employee;
import com.chainsys.springproject.component.MobilePhone;
import com.chainsys.springproject.beans.Customer;
public class TestAnnotationConfig {
	public static void testA() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Employee emp=ac.getBean(Employee.class);
		emp.setId(10);
		emp.setName("SACHIN");
		emp.print();
		Employee emp2=ac.getBean(Employee.class);
	}
	public static void testphone() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
		ac.scan("com.chainsys.springproject.component");
		ac.refresh();
		MobilePhone phone = ac.getBean(MobilePhone.class);
		phone.setPhoneNumber(9344067190l);
		long number = phone.getPhoneNumber();
		System.out.println("Phone Number" + number);
	}
}

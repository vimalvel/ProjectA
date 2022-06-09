package com.chainsys.projectA.getbeans;

import org.springframework.context.ApplicationContext;//Parent
import org.springframework.context.support.ClassPathXmlApplicationContext;//Child

import com.chainsys.projectA.beans.Actor;
import com.chainsys.projectA.beans.Customer;
import com.chainsys.projectA.beans.Employee;
import com.chainsys.projectA.beans.Lunch;
import com.chainsys.projectA.beans.Scoreboard;
import com.chainsys.projectA.beans.Calender;

public class TestClassPathXml {
	public static void testA() {
		Employee emp=new Employee();
		emp.setId(100);
		emp.setName("Vimal");
		emp.print();
	}
	public static void testB() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//Employee emp=ac.getBean(Employee.class);
		Employee emp=(Employee)ac.getBean("emp");
		emp.setId(100);
		emp.setName("Vel");
		emp.print();
		Customer c=ac.getBean(Customer.class);
		c.setName("Rohit");
		c.print();
	}
	public static void testC() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		Employee emp=ac.getBean(Employee.class);
		Customer c=ac.getBean(Customer.class);
		Employee secemp=ac.getBean(Employee.class);
		Customer secc=ac.getBean(Customer.class);
		System.out.println(emp.hashCode());
		System.out.println(secemp.hashCode());
		System.out.println(c.hashCode());
		System.out.println(secc.hashCode());
	}
	public static void testPrototype() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		Actor hero=ac.getBean(Actor.class);
		Actor heroin=ac.getBean(Actor.class);
		Actor comedian=ac.getBean(Actor.class);
		Actor friend=ac.getBean(Actor.class);
		System.out.println(hero.hashCode());
		System.out.println(heroin.hashCode());
		System.out.println(comedian.hashCode());
		System.out.println(friend.hashCode());
	}
	public static void testbeanwithconstructorparameter() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		
		
	}
	public static void testbeanwithconstructor() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
		
	}
	public static void testfactorymethod() {
		ApplicationContext ac1=new ClassPathXmlApplicationContext("bean.xml");
		Scoreboard sb=ac1.getBean("sb1",Scoreboard.class);
		sb.targetscore=300;
		System.out.println(sb.targetscore);
		Scoreboard sb2=ac1.getBean("sb",Scoreboard.class);
		System.out.println(sb2.targetscore);
		
	}
	public static void testCalenderFactory() {
		ApplicationContext ac1=new ClassPathXmlApplicationContext("bean.xml");
		Calender today=ac1.getBean(Calender.class);
		today.day=9;
		today.month="June";
		today.year=2022;
		System.out.println(today.day);
		System.out.println(today.month);
		System.out.println(today.year);
		}
	public static void testLunchFactory() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Lunch.xml");
		Lunch nvsilunch=ac.getBean("nvsilunch", Lunch.class);
		Lunch vsilunch=ac.getBean("vsilunch", Lunch.class);
		Lunch nilunch=ac.getBean("nilunch", Lunch.class);
		Lunch chlunch=ac.getBean("chlunch", Lunch.class);
		System.out.println("-----"); nvsilunch.serve();
		System.out.println("-- -");
		vsilunch.serve();
		System.out.println("-----");
		nilunch.serve();
		System.out.println("- -"); chlunch.serve();
		}
}


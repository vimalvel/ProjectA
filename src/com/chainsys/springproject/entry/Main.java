package com.chainsys.springproject.entry;


import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chainsys.springproject.dao.EmployeeSprings;
import com.chainsys.springproject.test.TestAnnotationConfig;
import com.chainsys.springproject.test.TestCar;
import com.chainsys.springproject.test.TestClassPathXml;
import com.chainsys.springproject.test.TestXmlBeanFactory;
public class Main {
	public static void main(String[] arg) {
		//TestXmlBeanFactory.testA();
		//TestAnnotationConfig.testA();
		//TestCar.firsttest();
//		TestClassPathXml.testInitDesposeBean();
//		TestClassPathXml.testautowirequalifer();
//		TestAnnotationConfig.testphone();
		//EmployeeSprings emps=new EmployeeSprings();
     // emps.DeleteEmployee();
      employeeMenu();
	}
	public static void employeeMenu() {
        ConfigurableApplicationContext apcontext=new ClassPathXmlApplicationContext("Employee.xml");
        EmployeeSprings empspring = apcontext.getBean(EmployeeSprings.class);
        Scanner sc=new Scanner(System.in);
        System.out.println("1.) To add New employee in to table");
        System.out.println("2.) To Get all employee datails from table");
        System.out.println("3.) To Update employee details");
        System.out.println("4.) To Delete Employee details");
        int vCase=sc.nextInt();
        switch(vCase) {
        case 1:
            empspring.addNewEmployee();
            break;
        case 2:
            empspring.GetEmplyeeById();
            break;
        case 3:
            empspring.UpdateEmployee();
            break;
        case 4:
            empspring.DeleteEmployee();
            break;
        default:
            System.out.println("enter valid number");
        }
        apcontext.close();
        sc.close();
    }
    
}
	



package com.cg.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile {

	public static void main(String[] args) {
		//Agenda - Spring IOC
		//1. We Should not touch the source code.
		//2. This Application should be configurable.
		//3. Hard-coding
		
		/*//For Airtel class Methods
		Airtel a=new Airtel();
		a.calling();
		a.data();
		
		//For Jio class Methods
		Jio j=new Jio();
		j.calling();
		j.data();*/
		
		
		ApplicationContext a=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Configuration Loading.....");
		/*//For Airtel class
		Airtel c=(Airtel)a.getBean("Airtel");
		c.calling();
		c.data();
		
		//For Jio class
		Jio j=(Jio)a.getBean("Jio");
		j.calling();
		j.data();*/
		
		Sim s=a.getBean("sim",Sim.class);
		s.calling();
		s.data();
	}

}

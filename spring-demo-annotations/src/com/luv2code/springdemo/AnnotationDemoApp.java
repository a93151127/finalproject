package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read the configuration file
		ClassPathXmlApplicationContext context=
		new ClassPathXmlApplicationContext("applicationContext.xml");
		// get the bean from spring container
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		// get the method
		System.out.println(theCoach.getDailyWorkout());
		
		//call new method
		System.out.println(theCoach.getDailyFortune());
		
		//close container
		context.close();
	}

}

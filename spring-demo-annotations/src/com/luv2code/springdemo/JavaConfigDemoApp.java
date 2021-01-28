package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		//read the config file
		AnnotationConfigApplicationContext context=new
		AnnotationConfigApplicationContext(SportConfig.class);
		//retrieve bean from spring container
		Coach theCoach=context.getBean("tennisCoach",Coach.class);
		//call the method
		System.out.println(theCoach.getDailyWorkout());
		//close context
		context.close();
	}

}

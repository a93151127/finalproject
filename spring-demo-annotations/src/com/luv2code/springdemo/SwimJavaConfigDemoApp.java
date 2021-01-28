package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		//read the config file
		AnnotationConfigApplicationContext context=new
		AnnotationConfigApplicationContext(SportConfig.class);
		//retrieve bean from spring container
		SwimCoach theCoach=context.getBean("swimCoach",SwimCoach.class);
		//call the method
		System.out.println(theCoach.getEmail());
		System.out.println(theCoach.getTeam());
		//close context
		context.close();
	}

}

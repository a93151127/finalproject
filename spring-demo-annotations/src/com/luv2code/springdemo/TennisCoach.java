package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("inside the constructor");
	}
	//define init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("inside init method");
	}
	//defin destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("inside destroy method");
	}
	
	/*@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService=theFortuneService;
	}*/
	
	@Override
	public String getDailyWorkout() {
		return "practice backhand";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}

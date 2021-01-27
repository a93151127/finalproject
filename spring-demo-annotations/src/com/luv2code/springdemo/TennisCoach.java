package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;
	
	public TennisCoach() {
		System.out.println("inside the constructor");
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

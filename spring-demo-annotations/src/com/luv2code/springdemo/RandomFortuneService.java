package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	//create string array
	String[] data= {
			"martin",
			"welson",
			"john",
			"josh",
			"nelson",
			"apple"
	};
 	//create random int
	private Random myRandom=new Random();
	
	@Override
	public String getFortune() {
		int index=myRandom.nextInt(data.length);
		String fortune=data[index];
		return fortune;
	}

}

package com.maxjspaulding.java.util;

import java.util.Random;

public class Rand {

	public static int rand5(Random random){
		return random.nextInt(5);
	}


	public static int rand7(Random random){
		int sum;
		do{
			sum  = rand5(random) * 5 + rand5(random);
		}while(sum > 20);

		return sum % 7;
	}

}
package com.maxjspaulding.java.util;

import com.maxjspaulding.java.util.Rand;

import java.util.Random;

public class TestApplication {

	public static void main(String[] args) {
		// Seed the generator
		Random random = new Random();

		// rand7
		int[] results = new int[7];
		for(int i=0; i<1000000; i++)
			results[Rand.rand7(random)]++;
		
		for(int i=0; i<7; i++)
			System.out.println(String.format("%d came up %d times", i, results[i]));
	}

}
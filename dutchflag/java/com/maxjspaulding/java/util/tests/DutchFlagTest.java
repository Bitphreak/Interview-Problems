package com.maxjspaulding.java.util.test;

import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collections;

import com.maxjspaulding.java.util.DutchFlag;

public class DutchFlagTest {

	enum Color {
		RED,
		WHITE,
		BLUE
	}

	public class ColorComparator implements DutchFlag.Comparator<Color> {

		public int compare(Color o){
			return o.compareTo(Color.WHITE);
		}

	}

	@Test
	public void testColors() {
		System.out.println("Inside testColors()");
		ArrayList<Color> colors = new ArrayList<>();

		for(int i = 0; i < 10; i++)
			colors.add(Color.RED);
	
		for(int i = 0; i < 10; i++)
			colors.add(Color.WHITE);

		for(int i = 0; i < 10; i++)
			colors.add(Color.BLUE);

		for(int t = 0; t < 20; t++) {
			
			ArrayList<Color> shuffledColors = new ArrayList<>(colors);
			Collections.shuffle(shuffledColors);


			assertFalse("List not shuffled", colors.equals(shuffledColors));

			DutchFlag.sort(shuffledColors, new ColorComparator());

			assertTrue("List not sorted", colors.equals(shuffledColors));

		}
   }
	
}

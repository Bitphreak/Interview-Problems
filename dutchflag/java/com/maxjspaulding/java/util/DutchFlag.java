package com.maxjspaulding.java.util;

import java.util.List;
import java.util.Collections;

public class DutchFlag {

	public interface Comparator<T extends Comparable> {
		/** compares object to the mid point
		  */
		public int compare(T o);
	}

	public static <T extends Comparable> void sort(List<T> list, DutchFlag.Comparator<T> c){

		int hi = 0;                // head insertion index
		int ci = 0;                // comparison index
		int ti = list.size() - 1;  // tail insertion index

		while (ci <= ti){
			int v = c.compare(list.get(ci));
			if ( v < 0 ) {

				// o is less than the mid point value, move it to head insert point of list
				Collections.swap(list, ci, hi);
				ci++;
				hi++;

			} else if ( v > 0 ) {

				// o is greater than the mid point value, move it to tail insert point of list
				Collections.swap(list, ci, ti);
				ti--;

			} else {

				ci++;

			}

		}

	}

}
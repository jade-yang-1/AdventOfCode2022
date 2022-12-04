package Helper;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author jyouayang
 *
 * Day 3 onwards 
 */
public final class Helper {
	/**
	 * @param a a char[]
	 * @param b a char[] 
	 * @param c a char[]
	 * @return the repeated character in char[] a, char[] b, and char[] c 
	 */
	public static char findRepeatChar(char[] a, char[] b, char[] c) {
		for(int i=0; i< a.length; i++) {
			for(int j=0; j<b.length; j++) {
				for(int k=0; k<c.length; k++) {
					if(a[i] == b[j] && a[i] == c[k]) return a[i];
				}
			}
		}
		return '-';
	}
	/**
	 * Find the duplicate character between two arrays 
	 * @param a a char[]
	 * @param b a char[]
	 * @return the repeated character in char[] a and char[] b
	 */
	public static char findRepeatChar(char[] a, char[] b) {
		for(int i=0; i< a.length; i++) {
			for(int j=0; j<b.length; j++) {
				if(a[i] == b[j]) return a[i];
			}
		}
		return '-';
	}
	/**
	 * Remove duplicates in a char array. 
	 * @param arr a char[]
	 * @return return a char[] that contains no duplicate characters 
	 */
	public static char[] removeDuplicates(char arr[]) {
		String ret = "";
		for(int i = 0; i< arr.length; i++) {
			if(ret.contains(arr[i]+"")) continue;
			else ret += String.valueOf(arr[i]);
		}
		return ret.toCharArray();
	}
	/**
	 * Remove duplicates in a string. 
	 * @param s string to have duplicates removed 
	 * @return a string with no duplicate characters 
	 */
	public static String removeDuplicates(String s) {
		String ret = "";
		for(int i = 0; i< s.length(); i++) {
			if(ret.contains(s.charAt(i)+"")) continue;
			else ret += s.charAt(i);
		}
		return ret;
	}
	/**
	 * Get the max int from an arraylist 
	 * @param a an arraylist of integers 
	 * @return the max int in the arraylist 
	 */
	public static int getMaxInt(ArrayList<Integer> a) {
		//sort the arraylist in reverse order, so it is in descending order 
		Collections.sort(a, Collections.reverseOrder());
		return a.get(0);
	}
	/**
	 * Get the max int from an int[] 
	 * @param a an arraylist of integers 
	 * @return the max int in the arraylist 
	 */
	public static int getMaxInt(int [] a) {
		int max = Integer.MIN_VALUE;
		for(int x : a)
			if(max <= x) max = x;
		return max;
	}
	
}

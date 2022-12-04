package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("your_path\\input.txt");
		Scanner sc = new Scanner(input);
		int totalPriority = 0;
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			String r1 = s.substring(0,s.length()/2);
			String r2 = s.substring(s.length()/2);
//			System.out.println(s.substring(0,s.length()/2) + " " + s.substring(s.length()/2));
			
			//sort the rucksacks
			char temp1[] = (s.substring(0, s.length()/2)).toCharArray();
			char temp2[] = s.substring(s.length()/2).toCharArray();
//			System.out.println("unsorted: " + Arrays.toString(temp1));
			Arrays.sort(temp1);
			Arrays.sort(temp2);
			
			//remove duplicates in the rucksacks 
			char temp1NoDupes[] = removeDuplicates(temp1);
			char temp2NoDupes[] = removeDuplicates(temp2);
//			System.out.println("sorted: " + Arrays.toString(temp1));
//			System.out.println("No Dupes: " + Arrays.toString(temp1NoDupes));
//			System.out.println("No Dupes: " + Arrays.toString(temp2NoDupes));
			
			//compare for repeat character in the rucksack 
			char r = findRepeatChar(temp1NoDupes,temp2NoDupes);
//			System.out.println("repeat: " + r + (char)(int)r + "\n");
			System.out.println("repeat: " + r);
			//add priority of r to total
			totalPriority += getPriority(r);
		}
		System.out.println(totalPriority);
	}
	
	public static int getPriority(char c) {	
		// ascii value of a-z is 97 - 122
		// ascii value of A-Z is 65 - 90 
		int asciiValue = (int)c;
		if(asciiValue <= 90) 
			return asciiValue - 38; //then it is between A-Z
		else 
			return asciiValue - 96;
		

	}
	public static char findRepeatChar(char[] a, char[] b) {
		for(int i=0; i< a.length; i++) {
			for(int j=0; j<b.length; j++) {
				if(a[i] == b[j]) return a[i];
			}
		}
		return '-';
	}
	public static char[] removeDuplicates(char arr[]) {
		String ret = "";
		for(int i = 0; i< arr.length; i++) {
			if(ret.contains(arr[i]+"")) continue;
			else ret += String.valueOf(arr[i]);
		}
		return ret.toCharArray();
	}

}
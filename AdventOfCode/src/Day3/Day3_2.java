package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day3_2 {

	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day3\\input.txt");
		Scanner sc = new Scanner(input);
		int totalPriority = 0;
		ArrayList<char[]> hold3 = new ArrayList<>();
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			
			//sort the rucksacks
			char temp[] = s.toCharArray();
//			System.out.println("unsorted: " + Arrays.toString(temp1));
			Arrays.sort(temp);
			
			//remove duplicates in the rucksacks 
			char tempNoDupes[] = removeDuplicates(temp);
//			System.out.println("sorted: " + Arrays.toString(temp));
//			System.out.println("noDupes: " + Arrays.toString(tempNoDupes));
//			System.out.println();
			
			//we want to compare 3 rucksacks to hold on to 3
			if(hold3.size() < 3) hold3.add(tempNoDupes);
			
			//compare for repeat character in the rucksacks
			//add priority of r to total
			if(hold3.size() == 3) {
				char r = findRepeatChar(hold3.get(0), hold3.get(1), hold3.get(2));
				totalPriority += getPriority(r);
				//then clear the hold3 arraylist 
				hold3.clear();
			}
		}
		System.out.println(totalPriority);
	}
	
	public static int getPriority(char c) {	
		// ascii value of a-z is 97 - 122
		// ascii value of A-Z is 65 - 90 
		int asciiValue = (int)c;
		if(asciiValue <= 90) return asciiValue - 38; //then it is between A-Z 
		else return asciiValue - 96;
	}
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
	public static char[] removeDuplicates(char arr[]) {
		String ret = "";
		for(int i = 0; i< arr.length; i++) {
			if(ret.contains(arr[i]+"")) continue;
			else ret += String.valueOf(arr[i]);
		}
		return ret.toCharArray();
	}
}
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

		if(asciiValue <= 90) {	//then it is between A-Z 
			return asciiValue - 38;
		}else {
			return asciiValue - 96;
		}
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
			if(ret.contains(arr[i]+"")) {
				continue;
			}else {
				ret += String.valueOf(arr[i]);
			}
		}
		return ret.toCharArray();
	}
}

//Prompt 
//As you finish identifying the misplaced items, the Elves come to you with another issue.
//For safety, the Elves are divided into groups of three. Every Elf carries a badge that identifies their group. 
//For efficiency, within each group of three Elves, the badge is the only item type carried by all three Elves. 
//That is, if a group's badge is item type B, then all three Elves will have item type B somewhere in their rucksack, 
//and at most two of the Elves will be carrying any other item type.

//The problem is that someone forgot to put this year's updated authenticity sticker on the badges. 
//All of the badges need to be pulled out of the rucksacks so the new authenticity stickers can be attached.

//Additionally, nobody wrote down which item type corresponds to each group's badges. The only way to 
//tell which item type is the right one is by finding the one item type that is common between all three Elves in each group.

//Every set of three lines in your list corresponds to a single group, but each group can have a 
//different badge item type. So, in the above example, the first group's rucksacks are the first three lines:

//vJrwpWtwJgWrhcsFMMfFFhFp
//jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
//PmmdzqPrVvPwwTWBwg
//And the second group's rucksacks are the next three lines:

//wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
//ttgJtRGJQctTZtZT
//CrZsJsPPZsGzwwsLwLmpwMDw

//In the first group, the only item type that appears in all three rucksacks is lowercase r; 
//this must be their badges. In the second group, their badge item type must be Z.

//Priorities for these items must still be found to organize the sticker attachment efforts: 
//here, they are 18 (r) for the first group and 52 (Z) for the second group. The sum of these is 70.

//Find the item type that corresponds to the badges of each three-Elf group. What is the sum of the priorities of those item types?
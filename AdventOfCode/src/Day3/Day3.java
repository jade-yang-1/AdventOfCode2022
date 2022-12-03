package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day3 {

	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day3\\input.txt");
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

		if(asciiValue <= 90) {	//then it is between A-Z 
			return asciiValue - 38;
		}else {
			return asciiValue - 96;
		}

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
//One Elf has the important job of loading all of the rucksacks with supplies for the jungle journey. 
//Unfortunately, that Elf didn't quite follow the packing instructions, and so a few items now need to be rearranged.
//Each rucksack has two large compartments. All items of a given type are meant to go into exactly 
//one of the two compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.
//The Elves have made a list of all of the items currently in each rucksack (your puzzle input), 
//but they need your help finding the errors. Every item type is identified by a single lowercase 
//or uppercase letter (that is, a and A refer to different types of items).

//The list of items for each rucksack is given as characters all on a single line. 
//A given rucksack always has the same number of items in each of its two compartments, 
//so the first half of the characters represent items in the first compartment, 
//while the second half of the characters represent items in the second compartment.

//For example, suppose you have the following list of contents from six rucksacks:
//vJrwpWtwJgWrhcsFMMfFFhFp
//jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
//PmmdzqPrVvPwwTWBwg
//wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
//ttgJtRGJQctTZtZT
//CrZsJsPPZsGzwwsLwLmpwMDw

//The first rucksack contains the items vJrwpWtwJgWrhcsFMMfFFhFp, 
//which means its first compartment contains the items vJrwpWtwJgWr, 
//while the second compartment contains the items hcsFMMfFFhFp. 
//The only item type that appears in both compartments is lowercase p.

//The second rucksack's compartments contain jqHRNqRjqzjGDLGL and rsFMfFZSrLrFZsSL. 
//The only item type that appears in both compartments is uppercase L.

//The third rucksack's compartments contain PmmdzqPrV and vPwwTWBwg; the only common item type is uppercase P.
//The fourth rucksack's compartments only share item type v.
//The fifth rucksack's compartments only share item type t.
//The sixth rucksack's compartments only share item type s.
//To help prioritize item rearrangement, every item type can be converted to a priority:

//Lowercase item types a through z have priorities 1 through 26.
//Uppercase item types A through Z have priorities 27 through 52.
//In the above example, the priority of the item type that appears in both compartments of each 
//rucksack is 16 (p), 38 (L), 42 (P), 22 (v), 20 (t), and 19 (s); the sum of these is 157.

//Find the item type that appears in both compartments of each rucksack. What is the sum of the priorities of those item types?
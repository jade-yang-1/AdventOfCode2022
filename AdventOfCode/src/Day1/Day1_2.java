package Day1;
//Author: Jade Yang 
// Calorie Counting Part 2 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day1_2 {
	 public static void main (String [] args) throws FileNotFoundException {
		 //count each elves's total calories
		 //blank line delimter
		 File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day1\\input.txt");
		 Scanner sc = new Scanner(input);
		 int total = 0;
		 ArrayList<Integer> totalCaloriesPerElf = new ArrayList<>();
		 while(sc.hasNextLine()) {
			 String s = sc.nextLine();
			 if(s.isBlank()) {
//				 System.out.print(total + ", ");
				 totalCaloriesPerElf.add(total);
				 total = 0;
				 continue;
			 }
			 total += Integer.parseInt(s);
		 }
//		 System.out.println(total);
		 totalCaloriesPerElf.add(total);
		 // now we have a list of all the total calories per elf 
		 // order by decending, get top three total calories
		 Collections.sort(totalCaloriesPerElf, Collections.reverseOrder());
		 System.out.println(totalCaloriesPerElf.toString());
		 
		 System.out.println("total calories of top three elves= " + (totalCaloriesPerElf.get(0) + totalCaloriesPerElf.get(1) + totalCaloriesPerElf.get(2)));
	 }
}

//Prompt
//By the time you calculate the answer to the Elves' question, they've already realized 
//that the Elf carrying the most Calories of food might eventually run out of snacks.
//
//To avoid this unacceptable situation, the Elves would instead like to know the total 
//Calories carried by the top three Elves carrying the most Calories. That way, even if 
//one of those Elves runs out of snacks, they still have two backups.
//
//In the example above, the top three Elves are the fourth Elf (with 24000 Calories), 
//then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories). 
//The sum of the Calories carried by these three elves is 45000.
//
//Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?

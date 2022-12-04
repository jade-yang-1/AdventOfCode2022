package Day1; 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 * Calorie Counting Part 2
 * @author jyouayang
 *
 */
public class Day1_2 {
	 public static void main (String [] args) throws FileNotFoundException {
		 //count each elves's total calories
		 //blank line delimter
		 File input = new File("your_path\\input.txt");
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

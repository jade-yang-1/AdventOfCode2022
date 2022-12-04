package Day1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Calorie Counting Part 1 
 * @author jyouayang
 *
 */
public class Day1 {
	 public static void main (String [] args) throws FileNotFoundException {
		 //count each elves's total calories
		 //blank line delimter
		 File input = new File("your_path\\input.txt");
		 Scanner sc = new Scanner(input);
		 int total = 0;
		 int maxCalories = -1;
		 while(sc.hasNextLine()) {
			 String s = sc.nextLine();
			 if(s.isBlank()) {
//				 System.out.print(total + ", ");
				 if(total > maxCalories)
					 maxCalories = total;
				 total = 0;
				 continue;
			 }
			 total += Integer.parseInt(s);
		 }
//		 System.out.println(total);
		 if(total > maxCalories)
			 maxCalories = total;
		 System.out.println("max calories = " + maxCalories);
	 }
}

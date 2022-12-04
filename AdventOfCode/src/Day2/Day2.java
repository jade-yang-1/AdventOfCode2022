package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Rock, Paper, Scissors Part 1
 * @author jyouayang
 *
 */
public class Day2 {
	/* 
	 * A = ROCK
	 * B = PAPER
	 * C = SCISSORS
	 * 
	 * X = ROCK = 1 pt
	 * Y = PAPER = 2 pt 
	 * Z = SCISSORS = 3 pt 
	 * 
	 */
	
	/* Winning Logic 
	 * A v X = Rock v Rock = draw, 1 pt + 3 pt 		= 4
	 * A v Y = Rock v Paper = win, 2 pt + 6 pt 		= 8
	 * A v Z = Rock v Sci = lose, 3 pt + 0 pt 		= 3
	 * 
	 * B v X = Paper v Rock = lose, 1 pt + 0 pt 	= 1
	 * B v Y = Paper v Paper = draw, 2 pt + 3 pt 	= 5
	 * B v Z = Paper v Sci = win, 3 pt + 6 pt		= 9
	 * 
	 * C v X = Scis v Rock = win, 1 pt + 6 pt 		= 7
	 * C v Y = Scis v Paper = lose, 2 pt + 0 pt 	= 2
	 * C v Z = Sci v Sci = draw, 3 pt + 3 pt		= 6
	 * 
	 */
	
	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("your_path\\input.txt");
		Scanner sc = new Scanner(input);
		int total = 0;
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			s = s.replaceAll("\\s","");		//decided to just keep the guide inputs together rather than splitting it up 
			total += calculatePoints(s);
//			System.out.println(s);
		}
		System.out.println(total);
	}
	
	public static int calculatePoints(String s) {
		if(s.compareTo("AX") == 0) return 4;
		if(s.compareTo("AY") == 0) return 8;
		if(s.compareTo("AZ") == 0) return 3;
		
		if(s.compareTo("BX") == 0) return 1;
		if(s.compareTo("BY") == 0) return 5;
		if(s.compareTo("BZ") == 0) return 9;
		
		if(s.compareTo("CX") == 0) return 7;
		if(s.compareTo("CY") == 0) return 2;
		if(s.compareTo("CZ") == 0) return 6;
		
		return 0;
	}
}
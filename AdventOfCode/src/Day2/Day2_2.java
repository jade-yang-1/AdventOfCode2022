package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day2_2 {
	/* 
	 * A = ROCK = 1
	 * B = PAPER = 2 
	 * C = SCISSORS = 3
	 * 
	 * X = LOSE
	 * Y = DRAW
	 * Z = WIN
	 */
	
	/* Winning Logic 
	 * input = meaning = points from your move + outcome = total => what your move should be to get that outcome 
	 * A v X = lose to rock = 3 + 0 		= 3 => Scissor 
	 * A v Y = draw with rock = 1 + 3 		= 4 => Rock
	 * A v Z = win against rock = 2 + 6 	= 8 => Paper
	 * 
	 * B v X = lose to paper = 1 + 0 		= 1 => Rock
	 * B v Y = draw with paper = 2 + 3 		= 5 => Paper
	 * B v Z = win against paper = 3 + 6 	= 9 => Scissor 
	 * 
	 * C v X = lose to scissor = 2 + 0 		= 2 => Paper
	 * C v Y = draw with scissor = 3 + 3 	= 6 => Scissor
	 * C v Z = win against scissor = 1 + 6 	= 7 => Rock
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
		if(s.compareTo("AX") == 0) return 3;
		if(s.compareTo("AY") == 0) return 4;
		if(s.compareTo("AZ") == 0) return 8;
		
		if(s.compareTo("BX") == 0) return 1;
		if(s.compareTo("BY") == 0) return 5;
		if(s.compareTo("BZ") == 0) return 9;
		
		if(s.compareTo("CX") == 0) return 2;
		if(s.compareTo("CY") == 0) return 6;
		if(s.compareTo("CZ") == 0) return 7;
		
		return 0;
	}
}

//Prompt 
//The Elf finishes helping with the tent and sneaks back over to you. 
//"Anyway, the second column says how the round needs to end: "
//+ "X means you need to lose, Y means you need to end the round in a draw, "
//+ "and Z means you need to win. Good luck!"

//The total score is still calculated in the same way, but now you need to 
//figure out what shape to choose so the round ends as indicated. The example above now goes like this:

//In the first round, your opponent will choose Rock (A), and you need the round to end in a draw (Y), 
//so you also choose Rock. This gives you a score of 1 + 3 = 4.
//In the second round, your opponent will choose Paper (B), 
//and you choose Rock so you lose (X) with a score of 1 + 0 = 1.
//In the third round, you will defeat your opponent's Scissors with Rock for a score of 1 + 6 = 7.
//Now that you're correctly decrypting the ultra top secret strategy guide, you would get a total score of 12.

//Following the Elf's instructions for the second column, what would your total 
//score be if everything goes exactly according to your strategy guide?
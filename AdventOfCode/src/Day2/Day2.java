package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

//Prompt 
//The Elves begin to set up camp on the beach. To decide whose tent gets to be closest to the 
//snack storage, a giant Rock Paper Scissors tournament is already in progress.

//Rock Paper Scissors is a game between two players. Each game contains many rounds; in each round, 
//the players each simultaneously choose one of Rock, Paper, or Scissors using a hand shape. 
//Then, a winner for that round is selected: Rock defeats Scissors, Scissors defeats Paper, 
//and Paper defeats Rock. If both players choose the same shape, the round instead ends in a draw.
//
//Appreciative of your help yesterday, one Elf gives you an encrypted strategy guide (your puzzle input) 
//that they say will be sure to help you win. "The first column is what your opponent is going to "
//+ "play: A for Rock, B for Paper, and C for Scissors. The second column--" Suddenly, 
//the Elf is called away to help with someone's tent.

//The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, 
//and Z for Scissors. Winning every time would be suspicious, so the responses must have been carefully chosen.

//The winner of the whole tournament is the player with the highest score. Your total 
//score is the sum of your scores for each round. The score for a single round is the score 
//for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors) plus the score 
//for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).

//Since you can't be sure if the Elf is trying to help you or trick you, you should 
//calculate the score you would get if you were to follow the strategy guide.

//For example, suppose you were given the following strategy guide:

//A Y
//B X
//C Z

//This strategy guide predicts and recommends the following:
//In the first round, your opponent will choose Rock (A), and you should choose Paper (Y). 
//This ends in a win for you with a score of 8 (2 because you chose Paper + 6 because you won).

//In the second round, your opponent will choose Paper (B), and you should choose Rock (X). 
//This ends in a loss for you with a score of 1 (1 + 0).

//The third round is a draw with both players choosing Scissors, giving you a score of 3 + 3 = 6.
//In this example, if you were to follow the strategy guide, you would get a total score of 15 (8 + 1 + 6).

//What would your total score be if everything goes exactly according to your strategy guide?
package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4_2 {
	 public static class Pair{
		private int x;
		private int y;
		private Pair() {
		}
		Pair(int x, int y) {
			this.x = x; 
			this.y = y;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
	}
	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day4\\input.txt");
		Scanner sc = new Scanner(input);
		int count = 0;
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			String commas[] = s.split(",");
			System.out.println("Original Line: " + Arrays.toString(commas));
			
			ArrayList<Pair> pairsList = new ArrayList<>();
			
			for(String c: commas) {
				String pairs[] = c.split("-");
				pairsList.add(new Pair(Integer.parseInt(pairs[0]), Integer.parseInt(pairs[1])));
			}
			
			//now check if the two pairs overlap at all
			if(win(pairsList.get(0), pairsList.get(1))) 
				count++;
			
		}
		System.out.println(count);
	}
	
	//"winning conditions"
	//if (p2x is in p1 range) at all, then they overlap 
	//if (p1x is in p2 range) at all, then they overlap 
	//I don't think I need to test for py since I think all of the data is ordered ascending
	//otherwise ignore 
	public static boolean win(Pair one, Pair two) {
		if (two.getX() >= one.getX() && two.getX() <= one.getY()) 
			return true;
		else if(one.getX() >= two.getX() && one.getX() <= two.getY()) 
			return true;
		else 
			return false;
		
	}
}
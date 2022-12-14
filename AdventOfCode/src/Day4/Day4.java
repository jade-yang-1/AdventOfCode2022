package Day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day4 {
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
//			System.out.println("Original Line: " + Arrays.toString(commas));
			
			ArrayList<Pair> pairsList = new ArrayList<>();
			
			for(String c: commas) {
				String pairs[] = c.split("-");
//				System.out.println(Arrays.toString(pairs));
				pairsList.add(new Pair(Integer.parseInt(pairs[0]), Integer.parseInt(pairs[1])));
			}
//			for(Pair p : pairsList) {
//				System.out.println("A pair is: (" + p.getX() + "," + p.getY() + ")");
//			}
//			System.out.println();
			
			//now check if either range of pairs completely contains the other 
			if(win(pairsList.get(0), pairsList.get(1)))
				count++;
		}
		System.out.println(count);
	}
	//"winning conditions"
	//p1_x < p2_x && p1_y > p2_y //Pair1 fully contains Pair2
	//p2_x < p1_x && p2_y > p1_y //Pair2 fully contains Pair1
	//otherwise ignore 
	public static boolean win(Pair one, Pair two) {
		if(one.getX() <= two.getX() && one.getY() >= two.getY())
			return true;
		else if(two.getX() <= one.getX() && two.getY() >= one.getY()) 
			return true;
		else 
			return false;
	}
}
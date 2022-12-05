package Day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Day5 {
	private static HashMap<Integer, LinkedList<String>> li;
	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day5\\input.txt");
		Scanner sc = new Scanner(input);
		int count = 0;
		
//		HashMap<Integer, LinkedList<String>> li = new HashMap<Integer, LinkedList<String>>();
		li = new HashMap<Integer, LinkedList<String>>();
		
		//initialize hashmap 
		for(int i=0; i<9; i++) {
			try {
				li.put(i,new LinkedList<String>());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//So, since we're given the input file, I'm going to hard code it for now lol and see if I can come up with something better later :/
		//Get all lines until blank line - want to parse this into a linked list of sorts 
		while(sc.hasNextLine()) {
			String s = sc.nextLine();

			if(s.charAt(1) != ' ') li.get(0).add(0,s.charAt(1)+"");
			if(s.charAt(5) != ' ') li.get(1).add(0,s.charAt(5)+"");
			if(s.charAt(9) != ' ') li.get(2).add(0,s.charAt(9)+"");
			if(s.charAt(13) != ' ') li.get(3).add(0,s.charAt(13)+"");
			if(s.charAt(17) != ' ') li.get(4).add(0,s.charAt(17)+"");
			if(s.charAt(21) != ' ') li.get(5).add(0,s.charAt(21)+"");
			if(s.charAt(25) != ' ') li.get(6).add(0,s.charAt(25)+"");
			if(s.charAt(29) != ' ') li.get(7).add(0,s.charAt(29)+"");
			if(s.charAt(33) != ' ') li.get(8).add(0,s.charAt(33)+"");
//			System.out.println(s);
			
			if(sc.hasNextInt()) break;
		}
		System.out.println("Original Stacks: "); 
		
		printPretty(li);
		
		sc.nextLine(); //walk over the stack numbers 
		sc.nextLine(); //walk over the blank line 
		
//		System.out.println("\nBeginning of moves: ");
		//parse moves 
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
//			System.out.println(s);
			parseMove(s);
//			printPretty(li);
//			System.out.println("===================================");
		}
		//get last value of each stack
		String res = "";
		for(int i = 0; i <= 8; i++)
			res += li.get(i).getLast();
		
		System.out.println("\nCrates at the top of each stack: " + res);
	}
	public static void printPretty(HashMap<Integer, LinkedList<String>> li) {
		Iterator it = li.values().iterator();
		int stack = 1;
		while(it.hasNext()) 
			System.out.println(stack++ + " " + it.next());
	}
	public static void doMove(int n, int o, int t) {
//		printPretty(li);
		for(int i = 0; i < n; i++){
			if(li.get(o-1).size() == 0) break;	//catch for empty stack
			String temp = li.get(o-1).removeLast();
//			System.out.println("temp is=" + temp);	
//			System.out.println(li.get(o-1));
			li.get(t-1).add(temp);
//			printPretty(li);
//			System.out.println();
		}
	}
	public static void parseMove(String move) {
		int numCrates = -1;
		int origin = -1;
		int target = -1;
		
		Scanner sc = new Scanner(move);
		while(sc.hasNext()) {
			String s = sc.next();
			if(isInteger(s)) {
//				System.out.println("s is " + s);
				if(numCrates == -1) {
					numCrates = Integer.parseInt(s);
					continue;
				}
				if(origin == -1) {
					origin = Integer.parseInt(s);
					continue;
				}
				if(target == -1) {
					target = Integer.parseInt(s);
					continue;
				}
			}
		}
		doMove(numCrates,origin,target);
	}
	public static boolean isInteger(String s) {
		try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
	}
}
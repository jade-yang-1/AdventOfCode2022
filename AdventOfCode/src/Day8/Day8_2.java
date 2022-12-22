package Day8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Helper.Helper;
/**
 * 
 * @author jyouayang
 *
 */
public class Day8_2 {
	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day8\\input.txt");
		Scanner sc = new Scanner(input);
		
		LinkedList<LinkedList<Tree>> map = new LinkedList<LinkedList<Tree>>();
		
		// Make the map first 
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
//			System.out.println(s);
			LinkedList<Tree> trees = new LinkedList<>();
			
			//initialize map with heights and unknown visibility
			for(int i=0; i < s.length(); i++) {
				int h = Integer.parseInt(String.valueOf(s.charAt(i)));
				Tree t = new Tree(h,'u',-1,-1,-1,-1);
				trees.add(t);
			}
			map.add(new LinkedList<Tree>(trees));
		}
		
		setNeighbors(map);
		calculateVisibilty(map);
		printMap(map);
//		System.out.println(calculateScenicScore(map));
	}
	
	public static int calculateScenicScore(LinkedList<LinkedList<Tree>> map) {
		int maxScore = Integer.MIN_VALUE;
		for(int i=0; i< map.size(); i++) {
			LinkedList<Tree> temp = map.get(i);
			for(int j=0; j<temp.size(); j++) {
				Tree t = temp.get(j);
				System.out.print(t.getHeight() + " ");
				
				List<Integer> north = new ArrayList<>();
				for(int k = 0; k < i; k++) {
					north.add(map.get(k).get(j).getHeight());
				}
				int nViews = numTreesViewable(north, t.getHeight());
				System.out.println("\t: north trees are: " + north.toString());
				System.out.println("\t\t num viewable trees: " + nViews);
				
				List<Integer> south = new ArrayList<>();
				for(int k = i+1; k < map.size(); k++) {
					south.add(map.get(k).get(j).getHeight());
				}
				int sViews = numTreesViewable(south, t.getHeight());
				System.out.println("\t: south trees are: " + south.toString());
				System.out.println("\t\t num viewable trees: " + sViews);
				
				List<Integer> west = new ArrayList<>();
				for(int k = 0; k < j; k++) {
					west.add(temp.get(k).getHeight());
				}
				int wViews = numTreesViewable(west, t.getHeight());
				System.out.println("\t: west trees are: " + west.toString());
				System.out.println("\t\t num viewable trees: " + wViews);
				
				List<Integer> east = new ArrayList<>();
				for(int k = j+1; k < temp.size(); k++) {
					east.add(temp.get(k).getHeight());
				}
				int eViews = numTreesViewable(east, t.getHeight());
				System.out.println("\t: east trees are: " + east.toString());
				System.out.println("\t\t num viewable trees: " + eViews);
				
				int score = (nViews * sViews * wViews * eViews);
				System.out.println("Viewing Score: " + score);
				
				if(score > maxScore)
					maxScore = score;
			}
		}
		return maxScore;
	}
	public static int numTreesViewable(List<Integer> li, int currentHeight) {
		int count = 0;
		for(int i=0; i < li.size(); i++) {
			if(li.get(i) >= currentHeight) {
				return count+1;
			}
			count++;
		}
		return count;
	}
	public static void calculateVisibilty(LinkedList<LinkedList<Tree>> map) {
		for(int i=0; i< map.size(); i++) {
			LinkedList<Tree> temp = map.get(i);
			for(int j=0; j<temp.size(); j++) {
				Tree t = temp.get(j);
				//if first row, then visible 
				if(i == 0) {
					t.setVisibilty('v');
					continue;
				}
				//if last row, then visible
				if(i == map.size()-1) {
					t.setVisibilty('v');
					continue;
				}
				//if first tree, then visible
				if(j == 0) {
					t.setVisibilty('v');
					continue;
				}
				//if last tree, then visible 
				if(j == temp.size()-1) {
					t.setVisibilty('v');
					continue;
				}
				//if all trees in the shortest direction towards the edge of the map are shorter, the tree is visible
				//get all visibility in N,S,E,W directions
				
//				System.out.print(t.getHeight() + " ");
				
				List<Integer> north = new ArrayList<>();
				for(int k = 0; k < i; k++) {
					north.add(map.get(k).get(j).getHeight());
				}
//				System.out.println("\t: north trees are: " + north.toString());
				
				List<Integer> south = new ArrayList<>();
				for(int k = i+1; k < map.size(); k++) {
					south.add(map.get(k).get(j).getHeight());
				}
//				System.out.println("\t: south trees are: " + north.toString());
				
				List<Integer> east = new ArrayList<>();
				for(int k = 0; k < j; k++) {
					east.add(temp.get(k).getHeight());
				}
//				System.out.println("\t: east trees are: " + north.toString());
				
				List<Integer> west = new ArrayList<>();
				for(int k = j+1; k < temp.size(); k++) {
					west.add(temp.get(k).getHeight());
				}
//				System.out.println("\t: west trees are: " + north.toString());
				
				//get the list with fewest elements in it 
//				List<Integer> fewest = fewestElements(north, south, east, west);
				//check  to see if the heights in the fewestElements list are less than the current tree height 
				if(currentTreeTallest(east, t.getHeight())){
					t.setVisibilty('v');
				}
				else if(currentTreeTallest(west, t.getHeight())){
					t.setVisibilty('v');
				}
				else if(currentTreeTallest(north, t.getHeight())){
					t.setVisibilty('v');
				}
				else if(currentTreeTallest(south, t.getHeight())){
					t.setVisibilty('v');
				}
			}
		}
	}
	public static boolean currentTreeTallest(List<Integer> a, int currentTreeHeight) {
		for(int i : a) {
			if(i > currentTreeHeight || i == currentTreeHeight) {
				return false;
			}
		}
		return true;
	}
	public static void setNeighbors(LinkedList<LinkedList<Tree>> map) {
		for(int i=0; i< map.size(); i++) {
			LinkedList<Tree> temp = map.get(i);
			for(int j=0; j<temp.size(); j++) {
				Tree t = temp.get(j);

				if(i==0) {	//first row then, so N stays -1 
					if(j != 0 && j < temp.size()-1) {	//if not 1st or last tree
						t.setEast(temp.get(j-1).getHeight());
						t.setWest(temp.get(j+1).getHeight());
						t.setSouth(map.get(i+1).get(j-1).getHeight());
					}
					if(j == 0 && j < temp.size()-1) {	//first tree
						t.setWest(temp.get(j+1).getHeight());
						t.setSouth(map.get(i+1).get(j).getHeight());
					}
					if(j == temp.size()-1) {	//last tree
						t.setEast(temp.get(j-1).getHeight());
						t.setSouth(map.get(i+1).get(j).getHeight());
					}
					continue;
				}
				if(i == temp.size()-1) {	//last row, so S stays -1 
					if(j != 0 && j < temp.size()-1) {	//if not 1st or last tree
						t.setEast(temp.get(j-1).getHeight());
						t.setWest(temp.get(j+1).getHeight());
						t.setNorth(map.get(i-1).get(j).getHeight());
					}
					if(j == 0 && j < temp.size()-1) {	//first tree
						t.setWest(temp.get(j+1).getHeight());
						t.setNorth(map.get(i-1).get(j).getHeight());
					}
					if(j == temp.size()-1) {	//last tree
						t.setEast(temp.get(j-1).getHeight());
						t.setNorth(map.get(i-1).get(j).getHeight());
					}
					continue;
				}
				else {
					if(j != 0 && j < temp.size()-1) {	//if not 1st or last tree
						t.setEast(temp.get(j-1).getHeight());
						t.setWest(temp.get(j+1).getHeight());
						t.setNorth(map.get(i-1).get(j).getHeight());
						t.setSouth(map.get(i+1).get(j).getHeight());
					}
					if((j == 0) && (j <= temp.size()-1)) {	//first tree
						t.setWest(temp.get(j+1).getHeight());
						t.setNorth(map.get(i-1).get(j).getHeight());
						t.setSouth(map.get(i+1).get(j).getHeight());
					}
					if(j == temp.size()-1) {	//last tree
						t.setEast(temp.get(j-1).getHeight());
						t.setNorth(map.get(i-1).get(j).getHeight());
						t.setSouth(map.get(i+1).get(j).getHeight());
					}
					
				}
			}
		}
	}
	public static void printMap(LinkedList<LinkedList<Tree>> map) {
		for(int i=0; i < map.size(); i++) {
			LinkedList<Tree> temp = (map.get(i));
			for(Tree t : temp) {
//				System.out.printf("[(%d,%c)-{E:%d, W:%d, N:%d, S:%d}] ", t.getHeight(),t.getVisibility(), t.getEast(),t.getWest(),t.getNorth(),t.getSouth());
				System.out.printf("[(%d,%c) ", t.getHeight(),t.getVisibility());
			}
			System.out.println("");
		}
	}

}
// 2d array of Tree objects 
// 2d linked list
// Tree(height, visibility status) 
// visibility statuses: v, n, u
// v = visible, n = not visible, u = unknown 

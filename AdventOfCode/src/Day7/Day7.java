package Day7;

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
 * Code for Day 7 (Part 1) is referenced from Daniel Persson's on YT: https://www.youtube.com/watch?v=RLYeKOTbEUI&t=1420s
 * 
 * @author jyouayang
 *
 */
public class Day7 {
	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day7\\input_small.txt");
		Scanner sc = new Scanner(input);
		
		//Make a list of all directories
		List<DirectoryEntry> allDirs = new ArrayList<>();
		
		DirectoryEntry rootDir = new DirectoryEntry(null, "/");
		DirectoryEntry currentDir = rootDir;
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			String sSplit[] = s.split(" ");
			System.out.println(Arrays.toString(sSplit));
			// If 2nd element is $ ls, skip 
			if(sSplit[0].compareTo("$") == 0) {
					if(sSplit[1].compareTo("cd") == 0) {
						if(sSplit[2].compareTo("/") == 0) {		//change back to root dir 
						currentDir = rootDir;
					} else if(sSplit[2].compareTo("..") == 0) {	//change to parent of current (i.e. move up one level) 
						currentDir = currentDir.getParent();
					} else {
						currentDir = currentDir.getDir(sSplit[2]);	//else, move to next dir 
					}
				}
			// If dir, add the new directory as a file of the current directory and as a new dir entry 
			} else if (sSplit[0].compareTo("dir") == 0) {
				DirectoryEntry newDir = new DirectoryEntry(currentDir, sSplit[1]);
				currentDir.addFile(newDir);
				allDirs.add(newDir);
			// If it is not any of the above, it is a file. Add a new file to the current directory 
			} else {
				currentDir.addFile(new FileEntry(sSplit[1], Long.parseLong(sSplit[0])));
			}
		}
		// count size of each directory 
		// .size for directoryEntry and fileEntry have to be the same. It doesn't coun't the dirEntry .size inside of another dirEntry otherwise 
		long count = 0;
		for(DirectoryEntry d : allDirs) {
			long size = d.size();
			if(size < 100000) {
				count += size;
			}
		}
		System.out.println(count);
	}
	
}
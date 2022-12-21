package Day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Helper.Helper;

public class Day7_2 {
	public static void main (String [] args) throws FileNotFoundException {
		File input = new File("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day7\\input.txt");
		Scanner sc = new Scanner(input);

		List<DirectoryEntry> allDirs = new ArrayList<>();
		
		DirectoryEntry rootDir = new DirectoryEntry(null, "/");
		DirectoryEntry currentDir = rootDir;
		
		while(sc.hasNextLine()) {
			String s = sc.nextLine();
			String sSplit[] = s.split(" ");
//			System.out.println(Arrays.toString(sSplit));
			if(sSplit[0].compareTo("$") == 0) {
				if(sSplit[1].compareTo("cd") == 0) {
					if(sSplit[2].compareTo("/") == 0) {
						currentDir = rootDir;
					} else if(sSplit[2].compareTo("..") == 0) {
						currentDir = currentDir.getParent();
					} else {
						currentDir = currentDir.getDir(sSplit[2]);
					}
				}
			} else if (sSplit[0].compareTo("dir") == 0) {
				DirectoryEntry newDir = new DirectoryEntry(currentDir, sSplit[1]);
				currentDir.addFile(newDir);
				allDirs.add(newDir);
			} else {
				currentDir.addFile(new FileEntry(sSplit[1], Long.parseLong(sSplit[0])));
			}
		}
		allDirs.add(rootDir);
		long totalAmountUsed = allDirs.get(allDirs.size()-1).size();
		System.out.println("Total space used: " + totalAmountUsed);
		long memoryRequired = 30000000 - (70000000 - totalAmountUsed);
		System.out.println("Memory Required Still: " + memoryRequired);
		
		List<DirectoryEntry> deleteOptions = new ArrayList<>();
		
		for(DirectoryEntry d : allDirs) {
			long size = d.size();
//			System.out.println(d.getNameOfDir() + " " + size);
			if(size > memoryRequired)
				deleteOptions.add(d);
		}
		long min = Long.MAX_VALUE;
		DirectoryEntry ret = null;
		for(DirectoryEntry d : deleteOptions) {
			long size = d.size();
//			System.out.println(d.getNameOfDir() + " " + size);
			if(size < min) {
				ret = d;
				min = size;
			}	
		}
		System.out.println(ret.size());
	}
	
}
package Day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import Helper.Helper;

public class Day6 {

	public static void main (String [] args) throws IOException {
		//Read in input as a string 
		String data = "";
		data = new String(Files.readAllBytes(
				Paths.get("C:\\AdventOfCode2022\\AdventOfCode2022\\AdventOfCode\\src\\Day6\\input.txt")));
//		System.out.println(data);
		
		//Add input into a list
		List<String> stream = new ArrayList<String>();
		for(int i=0; i<data.length(); i++) {
			stream.add(data.substring(i,i+1));
		}
		System.out.println(stream.toString());
		
		//Parse through the list using a window of size 4
		int charCount = 0;
		while((stream.size()-charCount) > 3) {
			List<String> window = stream.subList(charCount, charCount+4);
			System.out.println("window: " + window.toString());
			List<String> comp = window.stream().distinct().collect(Collectors.toList());
//			System.out.println(comp.toString());
			if(comp.size()==4) {
				System.out.print(charCount+4);
				break;
			}
			charCount++;
		}
	}
}
//packet marker = four char all diff
//streaming window 


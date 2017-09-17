package jz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
	
	public static void main(String[] args) throws IOException {
	    File f = new File(".");
	    printFile(f);
	}
	
	private static void printFile(File f) {
	    if(f != null) {
		if( f.isDirectory()) {
		    File[] files = f.listFiles();
		    for(File tmp : files) {
			printFile(tmp);
		    }
		} else {
		    System.out.println(f);
		}
	    }
	}
	
}

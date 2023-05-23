package com.example;

import java.io.File;
import java.util.Scanner;

import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;

public class RehashComp {
	public static void main(String[] args) {
		NSolution linearTable;
		NSquaredSolution quadraticTable;
		String[] files = {
			"testFiles/100.txt", "testFiles/500.txt", "testFiles/1000.txt", "testFiles/5000.txt"
		};
		for (String file : files) {
			try {
				Scanner scn = new Scanner(new File(file));
				

				scn.close();
			} catch (Exception e) {}
		}
	}
}

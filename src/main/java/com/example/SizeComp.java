package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;

public class SizeComp {
	public static void main(String[] args) {
		NSolution linearTable;
		NSquaredSolution quadraticTable;
		String[] files = {
			"comparisonFiles/50.txt", "comparisonFiles/100.txt",
			"comparisonFiles/500.txt", "comparisonFiles/1000.txt", 
			"comparisonFiles/5000.txt", "comparisonFiles/10000.txt"
		};
		for (String fname : files) 
		{
			try{
				Scanner scn = new Scanner(new File(fname));
				int size = scn.nextInt();
				FileWriter writer = new FileWriter("sizeResults/res_"+size+".txt");
				linearTable = new NSolution(size);
				while (scn.hasNext())
				{
					String next = scn.next();
					linearTable.insert(next);
				}
				int lvl1Size = linearTable.first_level_size(), lvl2Size = linearTable.second_level_size();
				writer.write("linear table:\n");
				writer.write("Lvl1 size = :" + lvl1Size + "\n");
				writer.write("Lvl2 size = :" + lvl2Size + "\n");
				writer.write("\n\n");
				linearTable = null;


				quadraticTable = new NSquaredSolution(size);
				scn = new Scanner(new File(fname));
				while(scn.hasNext())
				{
					String next = scn.next();
					quadraticTable.insert(next);
				}
				int quadSize = quadraticTable.size();
				writer.write("quadratic table:\n");
				writer.write("Size = :" + quadSize);
				quadraticTable = null;
				scn.close();
				writer.close();
			}
			catch (FileNotFoundException e) {}
			catch (IOException e) {}
		}
		
	}
}

package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


import com.example.Trees.*;
import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;

public class TreeTableComp {

	static final int searches = 800;
	
	public static void main(String[] args) {
		// String[] files = {
		// 	"comparisonFiles/50.txt", "comparisonFiles/100.txt",
		// 	"comparisonFiles/500.txt", "comparisonFiles/1000.txt", 
		// 	"comparisonFiles/5000.txt", "comparisonFiles/10000.txt"
		// };
		String[] files = {
			"comparisonFiles/50.txt", "comparisonFiles/10000.txt"
		};
		for (String fname : files) 
		{
			random_search(fname);
			// existing_search(fname);
		}
		
	}

	static void random_search(String fname)
	{
		try{
			NSolution linearTable;
			NSquaredSolution quadraticTable;
			Tree<String> tree;
			String[] searchTable = new String[searches];
			Random rand = new Random();
			Scanner scnTemp = new Scanner(new File("comparisonFiles/800.txt"));
			scnTemp.next();
			for (int i=0; i<searches; i++) searchTable[i] = scnTemp.next();


			Scanner scn = new Scanner(new File(fname));
			int size = scn.nextInt();
			FileWriter writer = new FileWriter("treeTableResults/rand_"+size+".txt");
			linearTable = new NSolution(size);
			while (scn.hasNext())
			{
				String next = scn.next();
				linearTable.insert(next);
			}

			long start = System.nanoTime();
			for (int i=0; i<searches; i++)
			{
				linearTable.search(searchTable[i]);
			}
			long time = System.nanoTime() - start;
			writer.write("linear table time = " + time / searches + "\n");
			linearTable = null;


			quadraticTable = new NSquaredSolution(size);
			scn = new Scanner(new File(fname));
			while(scn.hasNext())
			{
				String next = scn.next();
				quadraticTable.insert(next);
			}

			start = System.nanoTime();
			for (int i=0; i<searches; i++)
			{
				quadraticTable.search(searchTable[i]);
			}
			time = System.nanoTime() - start;
			writer.write("quadratic table time = " + time / searches + "\n");
			quadraticTable = null;


			tree = new AVL<String>();
			scn = new Scanner(new File(fname));
			while(scn.hasNext())
			{
				String next = scn.next();
				tree.insert(next);
			}

			start = System.nanoTime();
			for (int i=0; i<searches; i++)
			{
				tree.search(searchTable[i]);
			}
			time = System.nanoTime() - start;
			writer.write("avl time = " + time / searches + "\n");
			tree = null;


			tree = new RBTree<String>();
			scn = new Scanner(new File(fname));
			while(scn.hasNext())
			{
				String next = scn.next();
				tree.insert(next);
			}

			start = System.nanoTime();
			for (int i=0; i<searches; i++)
			{
				tree.search(searchTable[i]);
			}
			time = System.nanoTime() - start;
			writer.write("RB time = " + time / searches + "\n");
			tree = null;



			scn.close();
			writer.close();
		}
		catch (FileNotFoundException e) {}
		catch (IOException e) {}
	}

	static void existing_search(String fname)
	{
		try{
			NSolution linearTable;
			NSquaredSolution quadraticTable;
			Tree<String> tree;
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

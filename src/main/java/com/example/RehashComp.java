package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;

public class RehashComp {
	public static void main(String[] args) {
		NSolution linearTable;
		NSquaredSolution quadraticTable;
		String[] files = {
			"comparisonFiles/50.txt", 
			"comparisonFiles/100.txt", "comparisonFiles/200.txt", "comparisonFiles/500.txt", "comparisonFiles/800.txt", 
			"comparisonFiles/1000.txt", "comparisonFiles/2000.txt", "comparisonFiles/5000.txt", "comparisonFiles/8000.txt", 
			"comparisonFiles/10000.txt", "comparisonFiles/20000.txt", "comparisonFiles/50000.txt", "comparisonFiles/80000.txt", 
			"comparisonFiles/100000.txt", "comparisonFiles/200000.txt", "comparisonFiles/500000.txt", "comparisonFiles/800000.txt",
			"comparisonFiles/1000000.txt", "comparisonFiles/2000000.txt", "comparisonFiles/5000000.txt", "comparisonFiles/8000000.txt", 
			"comparisonFiles/10000000.txt"
		};
		for (int i=0; i < files.length; i++) {
			try {
				String fname = files[i];
				Scanner scn = new Scanner(new File(fname));
				int size = scn.nextInt();
				FileWriter writer = new FileWriter("RebuildResults/res_"+size+".txt");
				linearTable = new NSolution(size);
				// quadraticTable = new NSquaredSolution(size);
				int collCount = 0;
				int rebuildCount = 0;
				int minRebuildCount = -1;
				int maxRebuildCount = -1;
				double avgRebuilds;
				int medianRebuilds;
				PriorityQueue<Integer> rebuilds = new PriorityQueue<Integer>();
				while(scn.hasNext()){
					String next = scn.next();
					linearTable.insert(next);
					int prevCount = linearTable.get_prev_rebuilds();
					if (prevCount != 0)
					{
						collCount++;
						rebuildCount += prevCount;
						minRebuildCount = minRebuildCount > prevCount || minRebuildCount == -1 ? prevCount : minRebuildCount;
						maxRebuildCount = maxRebuildCount < prevCount || maxRebuildCount == -1 ? prevCount : maxRebuildCount;
						rebuilds.add(prevCount);
					}
				}
				avgRebuilds = (double)(rebuildCount) / collCount;
				for (int n=0; n<collCount/2-1; n++){
					rebuilds.remove();
				}
				medianRebuilds = rebuilds.poll();
				writer.write("linear table:\n");
				writer.write("#collisions = " + collCount);
				writer.write("\n#rebuilds = " + rebuildCount);
				writer.write("\n#max rebuilds = " + maxRebuildCount);
				writer.write("\n#min rebuilds = " + minRebuildCount);
				writer.write("\n#avg rebuilds/coll = " + avgRebuilds);
				writer.write("\n#median rebuilds/coll = " + medianRebuilds);
				writer.write("\n");

				// scn = new Scanner(new File(files[i]));
				// quadraticTable = new NSquaredSolution(size);
				// collCount = 0;
				// rebuildCount = 0;
				// minRebuildCount = -1;
				// maxRebuildCount = -1;
				// rebuilds = new PriorityQueue<Integer>();
				// while(scn.hasNext()){
				// 	String next = scn.next();
				// 	quadraticTable.insert(next);
				// 	int prevCount = quadraticTable.get_prev_rebuilds();
				// 	if (prevCount != 0)
				// 	{
				// 		collCount++;
				// 		rebuildCount += prevCount;
				// 		minRebuildCount = minRebuildCount > prevCount || minRebuildCount == -1 ? prevCount : minRebuildCount;
				// 		maxRebuildCount = maxRebuildCount < prevCount || maxRebuildCount == -1 ? prevCount : maxRebuildCount;
				// 		rebuilds.add(prevCount);
				// 	}
				// }
				// avgRebuilds = (double)(rebuildCount) / collCount;
				// for (int n=0; n<collCount/2-1; n++){
				// 	rebuilds.remove();
				// }
				// medianRebuilds = rebuilds.poll();
				// writer.write("Quadratic table:\n");
				// writer.write("#collisions = " + collCount);
				// writer.write("\n#rebuilds = " + rebuildCount);
				// writer.write("\n#max rebuilds = " + maxRebuildCount);
				// writer.write("\n#min rebuilds = " + minRebuildCount);
				// writer.write("\n#avg rebuilds/coll = " + avgRebuilds);
				// writer.write("\n#median rebuilds/coll = " + medianRebuilds);
				writer.close();

				scn.close();
			} catch (FileNotFoundException e) {
				System.out.println("Couldn't open file.");
			} catch(IOException e){
				System.out.println("Couldn't start FileWriter.");
			}
		}
	}
}

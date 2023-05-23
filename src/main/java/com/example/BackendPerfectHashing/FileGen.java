package com.example.BackendPerfectHashing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;

public class FileGen {
	static String chars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

	
	public static void main(String[] args) {
		int[] sizes = {
			50, 100, 200, 500, 800,
			1000, 2000, 5000, 8000,
			10000, 20000, 50000, 80000,
			100000, 200000, 500000, 800000,
			1000000, 2000000, 5000000, 8000000, 
			10_000_000, 
		};
		for (int i : sizes) {
			generate_file(i);
		}
		// generate_file(10000000);
	}

	static void generate_file(int size)
	{
		final int minLen = 1, maxLen = 8;
		Random rand = new Random();
		String fname = "comparisonFiles/" + size + ".txt";
		HashSet<String> strings = new HashSet<String>(size);
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fname));
			writer.write(size+"\n");
			while(size-- > 0)
			{
				int len = rand.nextInt(maxLen+1-minLen) + minLen;
				StringBuilder str = new StringBuilder();
				for (int i=0; i<len; i++)
				{
					char c = chars.charAt(rand.nextInt(chars.length()));
					str.append(c);
				}
				if (strings.contains(str.toString())){
					size++;
					continue;
				}
				strings.add(str.toString());
				writer.write(str.toString() + "\n");

			}
			writer.close();
		} catch (IOException e) {}
		
	}
}


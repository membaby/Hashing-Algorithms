package com.example.BackendPerfectHashing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.util.Random;

public class FileGen {
	static String chars = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";

	
	public static void main(String[] args) {
		generate_file(10_000_000);
	}

	static void generate_file(int size)
	{
		final int minLen = 1, maxLen = 8;
		Random rand = new Random();
		String fname = "comparisonFiles/" + size + ".txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(fname));
			while(size-- > 0)
			{
				int len = rand.nextInt(maxLen+1-minLen) + minLen;
				StringBuilder str = new StringBuilder();
				for (int i=0; i<len; i++)
				{
					char c = chars.charAt(rand.nextInt(chars.length()));
					str.append(c);
				}
				writer.write(str.toString() + "\n");

			}
			writer.close();
		} catch (IOException e) {}
		
	}
}


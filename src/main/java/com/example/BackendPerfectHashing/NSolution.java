package com.example.BackendPerfectHashing;
import java.util.*;

public class NSolution extends PerfectHashing{

	private int prevRebuilds = 0;
	private int size = 0;
	private Lvl2Table[] table;
	UniverseHashing hashFunc;

	// Constructor
	public NSolution(int size) 
	{
		
		size = 1 << (log2(size) + 1);
		table = new Lvl2Table[size];
		for (int i=0; i<size; i++)
		{
			table[i] = new Lvl2Table();
		}
		hashFunc = new UniverseHashing();
		hashFunc.newHashMatrix(size);
	}

	@Override
    public boolean insert(String key)
	{
		prevRebuilds = 0;
		String binaryStr = hashFunc.hash_string(key);
		int index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
		boolean res = table[index].insert(key);
		prevRebuilds = table[index].get_prev_rebuilds();
		if (res) size++;
		return res;
    }
	
    public boolean delete(String key)
	{
		String binaryStr = hashFunc.hash_string(key);
		int index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
		boolean res = table[index].delete(key);
		if (res) size--;
		return res;
    }

    public boolean search(String key){
        String binaryStr = hashFunc.hash_string(key);
		int index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
		
        return table[index].search(key);
    }

	public int size() {return size;}

	public int get_prev_rebuilds() {return prevRebuilds;}

	private int log2(int x)
	{
		int log = -1;
		for (;x > 0; log++)
		{
			x = x >> 1;
		}
		return log;
	}

	class Lvl2Table extends PerfectHashing 
	{
		private int prevRebuildCount;
		private int entryCount = 0;
		String[] table;
		UniverseHashing hashFunc;

		public Lvl2Table()
		{
			table = new String[1];
			hashFunc = new UniverseHashing();
			hashFunc.newHashMatrix(1);
		}


		public boolean insert(String key)
		{
			prevRebuildCount = 0;
			String binaryStr = hashFunc.hash_string(key);
			int index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
			//If key already exists
			if(search(key))	return false;
			entryCount++;
			//If no collision then don't rebuild
			if (table[index] == null)
			{
				table[index] = key;
				return true;
			}
			
			rebuild(key);

			//Comparing entry count to number of non null entries
			int count = 0;
			for (String entry : table) {
				if (entry != null) count++;
			}
			if (count != entryCount)
			{
				//Problems
				System.out.printf("Something went wrong during this insert.\n");
				System.out.printf("table length = %d. entryCount = %d\n", table.length, entryCount);
				System.out.printf("table contents: ");
				for (String string : table)System.out.printf(string + ", ");
				System.out.printf("\n");
				System.out.printf("New key = %s\n", key);
				System.out.println("Lvl 1 size = " + size);
				System.out.println("Rebuild count = " + prevRebuildCount);
				System.out.println();

			}
			
			return true;
		}

		public boolean search(String key)
		{
			String binaryStr = hashFunc.hash_string(key);
			int index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
			if (table[index] == null) return false;
			return table[index].equals(key);
		}

		public boolean delete(String key)
		{
			if (!search(key)) return false;
			String binaryStr = hashFunc.hash_string(key);
			int index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
			table[index] = null;
			entryCount -= 1;
			return true;
		}

		private void rebuild(String newKey)
		{
			String[] allEntries = new String[entryCount];
			allEntries[0] = newKey;
			int j = 1;
			for (int i=0; i<table.length; i++)
			{
				if (table[i] != null)
				{
					allEntries[j] = table[i];
					j++;
				}
			}
			if (j != entryCount)
			{
				System.out.printf("allEntries didn't fill up properly.\n");
				System.out.printf("table length = %d. j = %d. entryCount = %d\n", table.length, j, entryCount);
				System.out.printf("table contents: ");
				for (String string : table)System.out.printf(string + ", ");
				System.out.printf("\nallEntries contents: ");
				for (String string : allEntries) System.out.printf(string + ", ");
				System.out.println("Size = " + size);
			} 
			
			int log = log2(entryCount*entryCount);
			int size = 1 << (log+1);
			table = new String[size];
			prevRebuildCount = 0;
			findingNoCollisionsFunc:
			while(true)
			{
				prevRebuildCount++;
				hashFunc.newHashMatrix(table.length);
				table = new String[size];
				for (j=0; j<entryCount; j++)
				{
					// if (allEntries[j] == null) System.out.println("Is null");
					// else System.out.println(allEntries[j]);
					String binaryStr = hashFunc.hash_string(allEntries[j]);
					int index = 0;
					index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
					if (table[index] != null)
					{
						if (hashFunc.hash_string(newKey).equals(hashFunc.hash_string(table[index])))
						{
							//two strings with same hashcode
							hashFunc.newHashBase();
						}
						continue findingNoCollisionsFunc;
					} 
					table[index] = allEntries[j];
				}	
				break;
			}
		}

		public int get_prev_rebuilds(){return prevRebuildCount;}
	}
}

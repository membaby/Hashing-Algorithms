package com.example.BackendPerfectHashing;
import java.util.*;

public class NSolution extends PerfectHashing{

	private int size = 0;
	private Lvl2Table[] table;
	UniverseHashing hashFunc;

	// Constructor
	public NSolution(int size) 
	{
		
		size = 1 << log2(size);
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
		String binaryStr = hashFunc.hash_string(key);
        int index = 0;
		index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
		boolean res = table[index].insert(key);
		if (res) size++;
		return res;
    }
	
    public boolean delete(String key)
	{
		String binaryStr = hashFunc.hash_string(key);
        int index = 0;
		index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
		boolean res = table[index].delete(key);
		if (res) size--;
		return res;
    }

    public boolean search(String key){
        String binaryStr = hashFunc.hash_string(key);
        int index = 0;
		index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
		
        return table[index].search(key);
    }

	public int size() {return size;}

	private int log2(int x)
	{
		int log = 0;
		for (;size > 0; log++)
		{
			size = size >> 1;
		}
		return log;
	}

	class Lvl2Table extends PerfectHashing 
	{
		private int prevRebuildCount;
		private int entryCount = 0;
		String[] table = new String[0];
		UniverseHashing hashFunc = new UniverseHashing();


		public boolean insert(String key)
		{
			String binaryStr = hashFunc.hash_string(key);
			int index = 0;
			index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
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
			
			return true;
		}

		public boolean search(String key)
		{
			if (table.length == 0) return false;
			String binaryStr = hashFunc.hash_string(key);
			int index = 0;
			index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
			return table[index].equals(key);
		}

		public boolean delete(String key)
		{
			if (!search(key)) return false;
			String binaryStr = hashFunc.hash_string(key);
			int index = 0;
			index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
			table[index] = null;
			entryCount -= 1;
			return true;
		}

		private void rebuild(String newKey)
		{
			String[] allEntries = new String[entryCount];
			allEntries[0] = newKey;
			int j = 1;
			for (int i=0; i<table.length && j<entryCount; i++)
			{
				if (table[i] != null)
				{
					allEntries[j] = table[i];
					j++;
				}
			}
			
			int size = 1 << log2(entryCount*entryCount);
			table = new String[size];
			prevRebuildCount = -1;
			findingNoCollisionsFunc:
			while(true)
			{
				prevRebuildCount++;
				hashFunc.newHashMatrix(table.length);
				Arrays.fill(table, null);
				for (j=0; j<entryCount; j++)
				{
					String binaryStr = hashFunc.hash_string(allEntries[j]);
					int index = 0;
					index = hashFunc.hash(hashFunc.getHashMatrix(), binaryStr);
					if (table[index] != null) continue findingNoCollisionsFunc;
				}	
				break;
			}
		}

		public int get_prev_rebuilds(){return prevRebuildCount;}
	}
}

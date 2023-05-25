package com.example.BackendPerfectHashing;

public class NSolution extends PerfectHashing{

	private int prevRebuilds = 0;
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
		long numForm = hashFunc.hash_string(key);
		int index = hashFunc.hash(numForm);
		boolean res = table[index].insert(key);
		prevRebuilds = table[index].get_prev_rebuilds();
		return res;
    }
	
    public boolean delete(String key)
	{
		long numForm = hashFunc.hash_string(key);
		int index = hashFunc.hash(numForm);
		boolean res = table[index].delete(key);
		return res;
    }

    public boolean search(String key){
        long numForm = hashFunc.hash_string(key);
		int index = hashFunc.hash(numForm);
        return table[index].search(key);
    }

	public int first_level_size() {return table.length;}

	public int second_level_size() 
	{
		int accum = 0;
		for (Lvl2Table lvl2Table : table) {
			accum += lvl2Table.size();
		}
		return accum;
	}

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
			table = new String[2];
			hashFunc = new UniverseHashing();
			hashFunc.newHashMatrix(2);
		}


		public boolean insert(String key)
		{
			prevRebuildCount = 0;
			long numForm = hashFunc.hash_string(key);
			int index = hashFunc.hash(numForm);
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
			long numForm = hashFunc.hash_string(key);
			int index = hashFunc.hash(numForm);
			if (table[index] == null) return false;
			return table[index].equals(key);
		}

		public boolean delete(String key)
		{
			if (!search(key)) return false;
			long numForm = hashFunc.hash_string(key);
			int index = hashFunc.hash(numForm);
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
			int log = log2(entryCount*entryCount);
			int size = 1 << (log);
			if (size < entryCount*entryCount) size <<= 1;
			table = new String[size];
			prevRebuildCount = 0;
			findingNoCollisionsFunc:
			while(true)
			{
				prevRebuildCount++;
				hashFunc.newHashMatrix(size);
				table = new String[size];
				for (j=0; j<entryCount; j++)
				{
					String nextString = allEntries[j];
					long numForm = hashFunc.hash_string(allEntries[j]);
					int index = hashFunc.hash(numForm);
					if (table[index] != null)
					{
						String collisionString = table[index];
						long hash1 = hashFunc.hash_string(nextString);
						long hash2 = hashFunc.hash_string(collisionString);
						int i1 = hashFunc.hash(hash1);
						int i2 = hashFunc.hash(hash2);
						if (hashFunc.hash_string(allEntries[j]) == hashFunc.hash_string(table[index]))
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
		public int size() {return table.length;}
	}
}

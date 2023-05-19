package com.example.BackendPerfectHashing;


/*
 * In this method of hashing, A hash table of size m = n^2 is used (n is the size of the input).
 * A hash function is chosen randomly and hashing is attempted for all the keys. This is known as building the table
 * If a collision occurs then the table is rebuilt and hashing is reattempted.
 * Building the table will happen twice on average until a no-collisions function is found.
 * 
 * 
 * This method should end up using O(n^2) space and O(1) search\insert\delete time if done correctly.
 * A count of the number of rebuilds should be maintained for performance measuring
 * 
 */


import java.util.ArrayList;

public class NSquaredSolution extends PerfectHashing{

	private int rebuildCount = 0;
	private String[] hashTable;
	private int Size;
	private int TSize;
	private UniverseHashing hasher = new UniverseHashing();
	private ArrayList<String> elements = new ArrayList<>();
	private int getP2(int s){
		int po = 1 ;
		while (true){
			if (po >= s){
				return po;
			}
			po = po *2;
		}
	}

	// Constructor
	public NSquaredSolution(int size) {
		Size = size*size;
		TSize = getP2(Size);
		hashTable = new String[TSize];
		hasher.newHashMatrix(Size);
		/*
		* initialize hasher
		**/
	}

	@Override
    public boolean insert(String item){
		int hash = Integer.parseInt(hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item)),2);
		if (hashTable[hash] == null){
			elements.add(item);
			hashTable[hash] = item;
			for (int i = 0; i < TSize; i++) {
				if (hashTable[i] != null) {
					System.out.println("index at " + i + " is :" + hashTable[i]);
				}
			}
			return true;
		} else {
			if (hashTable[hash] != item){
				rehash(item);
				return true;
			}
			return false;
		}
    }
	@Override
    public boolean delete(String item){
		int hash = Integer.parseInt(hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item)),2);
		if (hashTable[hash] != null && hashTable[hash].equals(item)){
			hashTable[hash] = null;
			return true;
		}
        return false;
    }
	@Override
    public boolean search(String item){
		int hash = Integer.parseInt(hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item)),2);
		return hashTable[hash] != null && hashTable[hash].equals(item);
    }


	private void rehash(String item){
		ArrayList<String> newelements = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {
			if (search(elements.get(i))){
				newelements.add(elements.get(i));
			}
		}
		hasher.newHashMatrix(Size);
		int hash = Integer.parseInt(hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item)),2);
		String[] newhashTable = new String[TSize];
		newhashTable[hash] = item;
		newelements.add(item);
		for (int i = 0; i < newelements.size(); i++) {
				hash = Integer.parseInt(hasher.hash(hasher.getHashMatrix(), hasher.hash_string(newelements.get(i))),2);
				if (newhashTable[hash] == null){
					newhashTable[hash] = newelements.get(i);
				}
				else{
					hasher.newHashMatrix(Size);
					hash = Integer.parseInt(hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item)),2);
					newhashTable = new String[TSize];
					newhashTable[hash] = item;
					i = 0;
					rebuildCount++;
				}
		}
		hashTable = newhashTable;
		elements = newelements;
		rebuildCount++;
		for (int i = 0; i < TSize; i++) {
			if (hashTable[i] != null) {
				System.out.println("index at " + i + " is :" + hashTable[i]);
			}
		}
	}


	public int get_rebuild_count(){
		return rebuildCount;
	}



}

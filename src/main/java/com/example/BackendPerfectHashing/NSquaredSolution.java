package com.example.BackendPerfectHashing;
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
		TSize = Size;
		hashTable = new String[TSize];
		hasher.newHashMatrix(Size);
	}

	@Override
    public boolean insert(String item){
		int hash = hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item));
		if (hashTable[hash] == null){
			elements.add(item);
			hashTable[hash] = item;
			return true;
		} else {
			if (!hashTable[hash].equals(item)){
				rehash(item);
				return true;
			}
			return false;
		}
    }
	@Override
    public boolean delete(String item){
		int hash = hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item));
		if (hashTable[hash] != null && hashTable[hash].equals(item)){
			hashTable[hash] = null;
			return true;
		}
        return false;
    }
	@Override
    public boolean search(String item){
		int hash = hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item));
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
		int hash = hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item));
		String[] newhashTable = new String[TSize];
		newhashTable[hash] = item;
		newelements.add(item);
		for (int i = 0; i < newelements.size(); i++) {
				hash = hasher.hash(hasher.getHashMatrix(), hasher.hash_string(newelements.get(i)));
				if (newhashTable[hash] == null){
					newhashTable[hash] = newelements.get(i);
				}
				else{
					hasher.newHashMatrix(Size);
					hash = hasher.hash(hasher.getHashMatrix(), hasher.hash_string(item));
					newhashTable = new String[TSize];
					newhashTable[hash] = item;
					i = 0;
					rebuildCount++;
				}
		}
		hashTable = newhashTable;
		elements = newelements;
		rebuildCount++;
	}

	public int get_rebuild_count(){
		return rebuildCount;
	}
}

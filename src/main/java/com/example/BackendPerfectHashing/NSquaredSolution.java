package com.example.BackendPerfectHashing;
import java.util.ArrayList;

public class NSquaredSolution extends PerfectHashing{

	private int prevRebuilds = 0;
	private String[] hashTable;
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
		TSize = size*size;
		hashTable = new String[TSize];
		hasher.newHashMatrix(TSize);
		hasher.newHashBase();
	}

	@Override
    public boolean insert(String item){
		prevRebuilds = 0;
		int hash = hasher.hash(hasher.hash_string(item));
		if (hashTable[hash] == null){
			elements.add(item);
			hashTable[hash] = item;
			/*for (int i = 0; i < hashTable.length; i++) {
				if (hashTable[i] != null) {
					System.out.println("index " + i + " ---> " + hashTable[i]);
				}
			}*/
			return true;
		} else {
			if (!hashTable[hash].equals(item)){
				rehash(item);
				/*for (int i = 0; i < hashTable.length; i++) {
					if (hashTable[i] != null) {
						System.out.println("index " + i + " ---> " + hashTable[i]);
					}
				}*/
				return true;
			}
			return false;
		}
    }
	@Override
    public boolean delete(String item){
		int hash = hasher.hash(hasher.hash_string(item));
		if (hashTable[hash] != null && hashTable[hash].equals(item)){
			hashTable[hash] = null;
			return true;
		}
        return false;
    }
	@Override
    public boolean search(String item){
		int hash = hasher.hash(hasher.hash_string(item));
		return hashTable[hash] != null && hashTable[hash].equals(item);
    }


	private void rehash(String item){
		prevRebuilds = 1;
		ArrayList<String> newelements = new ArrayList<>();
		for (int i = 0; i < elements.size(); i++) {
			if (search(elements.get(i))){
				newelements.add(elements.get(i));
			}
		}
		hasher.newHashMatrix(TSize);
		int hash = hasher.hash(hasher.hash_string(item));
		String[] New_hashTable = new String[TSize];
		New_hashTable[hash] = item;
		newelements.add(item);
		for (int i = 0; i < newelements.size(); i++) {
				hash = hasher.hash(hasher.hash_string(newelements.get(i)));
				if (New_hashTable[hash] == null){
					New_hashTable[hash] = newelements.get(i);
				}
				else if (!New_hashTable[hash].equals(newelements.get(i))){
					System.out.println("word in table is:"+New_hashTable[hash]+" /binary value is:"+hasher.hash_string(New_hashTable[hash]));
					System.out.println("word to be added:"+newelements.get(i)+" /binary value is:"+hasher.hash_string(newelements.get(i)));
					if (hasher.hash_string(New_hashTable[hash]) == hasher.hash_string(newelements.get(i))){
						hasher.newHashBase();
						hash = hasher.hash(hasher.hash_string(item));
						New_hashTable = new String[TSize];
						New_hashTable[hash] = item;
						i = -1;
						prevRebuilds++;
					}
					else {
						hasher.newHashBase();
						hasher.newHashMatrix(TSize);
						hash = hasher.hash(hasher.hash_string(item));
						New_hashTable = new String[TSize];
						New_hashTable[hash] = item;
						i = -1;
						prevRebuilds++;
					}
				}
		}
		hashTable = New_hashTable;
		elements = newelements;
		prevRebuilds++;
	}

	public int get_prev_rebuilds(){
		return prevRebuilds;
	}
}

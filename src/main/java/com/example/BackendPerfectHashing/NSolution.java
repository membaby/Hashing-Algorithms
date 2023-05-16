package com.example.BackendPerfectHashing;
import java.util.*;


/*
 * In this method of hashing, two hashing levels are used.
 * The first level involves using a hash table of size m = n (n is the size of the input)
 * If a collision happens in the first level table then a secondary hash table is used to keys at this index.
 * This is similar to chaining except that another hash table is used instead of a linked list. 
 * If there are nj collisions in the jth index then the size of the second-level table must be mj = nj^2 
 * A hash function is chosen randomly for this second-level table and hashing is attempted. This is known as building the table
 * If a collision occurs in the second-level table then it is rebuilt and hashing is reattempted. Repeat until no collisions occur.
 * 
 * 
 * This method should end up using O(n) space and O(1) search\insert\delete time if done correctly.
 * A count of the number of rebuilds should be maintained for performance measuring
 * 
 */


public class NSolution extends IPerfectHash{

	private int rebuildCount = 0;
	private int firstLevelSize;
	private int[] firstLevelTable;
	private List<String>[] secondLevelTables;
	private Random random;

	// Constructor
	public NSolution(int size) {
		firstLevelSize = size;
		firstLevelTable = new int[firstLevelSize];
		secondLevelTables = new List[firstLevelSize];
		random = new Random();
	}

	@Override
    public boolean insert(String item){
        int firstLevelIndex = firstLevelHash(item);
		if (secondLevelTables[firstLevelIndex] == null) {
			secondLevelTables[firstLevelIndex] = new ArrayList<String>();
		}
		List<String> secondLevelTable = secondLevelTables[firstLevelIndex];
		int secondLevelIndex = secondLevelHash(item, secondLevelTable.size());
		if (secondLevelTable.get(secondLevelIndex) != null){
			return false; // Collision
		}
		secondLevelTable.set(secondLevelIndex, item);
		return true;
    }
    public boolean delete(String item){
		int firstLevelIndex = firstLevelHash(item);
		if (secondLevelTables[firstLevelIndex] == null) {
			return false; // Not found
		}
		List<String> secondLevelTable = secondLevelTables[firstLevelIndex];
		int secondLevelIndex = secondLevelHash(item, secondLevelTable.size());
		if (secondLevelTable.get(secondLevelIndex) != null && secondLevelTable.get(secondLevelIndex).equals(item)){
			secondLevelTable.set(secondLevelIndex, null);
			return true; // Deleted
		}
        return false; // Not Found
    }
    public boolean search(String item){
        int firstLevelIndex = firstLevelHash(item);
		if (secondLevelTables[firstLevelIndex] == null) {
			return false; // Not found
		}
		List<String> secondLevelTable = secondLevelTables[firstLevelIndex];
		int secondLevelIndex = secondLevelHash(item, secondLevelTable.size());
		return secondLevelTable.get(secondLevelIndex) != null && secondLevelTable.get(secondLevelIndex).equals(item);
    }

	private int firstLevelHash(String item) {
		// TODO: First Level Hash Implementation
		return 1;
	}

	private int secondLevelHash(String item, int size) {
		// TODO: Second Level Hash Implementation
		return 1;
	}

	/**
	 * Call this if a collision occurs in the secondary hash table at index to pick a different hash function for the table.
	 * 
	 * @param index the index of the second-level table to rebuild
	 */
	private void rebuild_secondLevel(int index){
		rebuildCount++;
		//Clear the secondary table and choose another hash function 
	}

	/**
	 * 
	 * @return the number of rebuilds that happened in the second-level
	 */
	public int get_rebuild_count(){
		return rebuildCount;
	} 
}

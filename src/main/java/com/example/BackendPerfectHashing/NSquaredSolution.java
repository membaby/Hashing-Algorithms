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


public class NSquaredSolution extends IPerfectHash{

	private int rebuildCount = 0;

    public boolean insert(String item){
        return false;
    }
    public boolean delete(String item){
        return false;
    }
    public boolean search(String item){
        return false;
    }

	/**
	 * Call this if a collision occurs in the secondary hash table at index to pick a different hash function for the table.
	 * 
	 * @param index the index of the second-level table to rebuild
	 */
	private void rebuild(){
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

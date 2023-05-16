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


public class NSquaredSolution implements IPerfectHash{
    public boolean insert(String item){
        return false;
    }
    public boolean delete(String item){
        return false;
    }
    public boolean search(String item){
        return false;
    }

}

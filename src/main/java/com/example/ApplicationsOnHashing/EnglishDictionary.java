package com.example.ApplicationsOnHashing;

import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;
import com.example.BackendPerfectHashing.PerfectHashing;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EnglishDictionary implements IDictionary {
    private PerfectHashing perfectHashing;
    public EnglishDictionary(String backendType, int tableSize){
        // Construction: creates a new EnglishDictionary object, using the specified backend type.
        if (backendType.equals("O(N2)")) {
            perfectHashing = new NSquaredSolution(tableSize);
        } else if (backendType.equals("O(N)")) {
            perfectHashing = new NSolution(tableSize);
        } else {
            throw new IllegalArgumentException("Invalid backend type: " + backendType);
        }
    }

    public boolean insert(String word)
    {
        return this.perfectHashing.insert(word);
    }

    public boolean delete(String word)
    {
        return this.perfectHashing.delete(word);
    }

    public boolean search(String word)
    {
        return this.perfectHashing.search(word);
    }


    //will return the number of words successfully inserted
    public int batchInsert(String filePath){
        return 0;
    }

    //will return the number of words successfully deleted
    public int batchDelete(String filePath){
        return 0;
    }
}

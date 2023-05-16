package com.example.ApplicationsOnHashing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class EnglishDictionary implements IDictionary {
    public EnglishDictionary(String backendType){
        // Construction: creates a new EnglishDictionary object, using the specified backend type.
        if (backendType.equals("O(N2)")) {
            // TODO: create a new EnglishDictionary object, using the O(N2) hashtable.
        } else if (backendType.equals("O(N)")) {
            // TODO: create a new EnglishDictionary object, using the O(N) hashtable.
        } else {
            throw new IllegalArgumentException("Invalid backend type: " + backendType);
        }
    }

    public boolean insert(String word){
        return false;
    }

    public boolean delete(String word){
        return false;
    }

    public boolean search(String word){
        return false;
    }

    public void batchInsert(String filePath){

    }

    public void batchDelete(String filePath){

    }


}

package com.example.ApplicationsOnHashing;

import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;
import com.example.BackendPerfectHashing.PerfectHashing;

import java.io.*;
import java.util.Scanner;

public class EnglishDictionary implements IDictionary {
    private PerfectHashing perfectHashing;
    public EnglishDictionary(String backendType, int tableSize){
        // Construction: creates a new EnglishDictionary object, using the specified backend type.
        if (backendType.equals("1")) {
            perfectHashing = new NSquaredSolution(tableSize);
        } else if (backendType.equals("2")) {
            perfectHashing = new NSolution(tableSize);
        } else if (backendType.equals("3")){
            System.exit(0);
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
        int countSuccessfulInsertions = 0 ;
        try
        {
            File file = new File(filePath);
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                if(this.perfectHashing.insert(scanFile.nextLine()))
                {
                    countSuccessfulInsertions ++;
                }

            }


        }catch (FileNotFoundException e){
            System.out.println(filePath + "is not found");
            e.printStackTrace();
        }
        return countSuccessfulInsertions;
    }

    //will return the number of words successfully deleted
    public int batchDelete(String filePath){
        int countSuccessfulDeletions = 0 ;
        try
        {
            File file = new File(filePath);
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                if(this.perfectHashing.delete(scanFile.nextLine()))
                {
                    countSuccessfulDeletions ++;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println(filePath + "is not found");
            e.printStackTrace();
        }
        return countSuccessfulDeletions;
    }
}

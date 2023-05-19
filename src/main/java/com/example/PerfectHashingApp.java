package com.example;

import com.example.ApplicationsOnHashing.DictionaryHandler;
import com.example.ApplicationsOnHashing.EnglishDictionary;
import com.example.BackendPerfectHashing.UniverseHashing;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class PerfectHashingApp
{

    public static void printTableMenu(){
        System.out.println("Choices");
        System.out.println("1. O(N2) solution");
        System.out.println("2. O(N) solution");
        System.out.println("3. Exit");
        System.out.println("Choose your hash method: ");
    }
    public static void printActionMenu(){
        System.out.println("Choices");
        System.out.println("1. Insert a word");
        System.out.println("2. Delete a word");
        System.out.println("3. Search for a word");
        System.out.println("4. Batch insert");
        System.out.println("5. Batch delete");
        System.out.println("6. Exit");
        System.out.println("Enter an action to perform: ");
    }

    public static void main( String[] args ) throws IOException, InterruptedException {
        UniverseHashing universeHashing = new UniverseHashing();
        String binaryString = universeHashing.hash_string("hello");
        System.out.println(binaryString);
        String hx = universeHashing.hash(binaryString, 100);
        universeHashing.setHashString(hx);
        for(int i = 0 ; i < 100 ; i ++)
        {
            //test that getters and setters works just fine
            System.out.println(universeHashing.getHashString());
        }

        //CLI implementation
        Scanner scanner = new Scanner(System.in);
        EnglishDictionary englishDictionary ;
        String tableChoice = "";
        String methodChoice = "";
        int tableSize = 0;
        printTableMenu();
        tableChoice = scanner.next();
        if(tableChoice.equals("3")) System.exit(0);
        System.out.println("Enter the size of the hash table: ");
        tableSize = scanner.nextInt();
        while(true)
        {
            printActionMenu();
            methodChoice = scanner.next();
            if(methodChoice.equals("6")) System.exit(0);
            new DictionaryHandler(methodChoice, tableSize, tableChoice);
        }
    }
}

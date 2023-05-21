package com.example;

import com.example.ApplicationsOnHashing.DictionaryHandler;
import com.example.BackendPerfectHashing.UniverseHashing;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PerfectHashingApp
{

    public static void printTableMenu()
    {
        System.out.println("Choices");
        System.out.println("1. O(N2) solution");
        System.out.println("2. O(N) solution");
        System.out.println("3. Exit");
        System.out.print("Choose your hash method: ");
    }
    public static void printActionMenu()
    {
        System.out.println("Choices");
        System.out.println("1. Insert a word");
        System.out.println("2. Delete a word");
        System.out.println("3. Search for a word");
        System.out.println("4. Batch insert");
        System.out.println("5. Batch delete");
        System.out.println("6. Main Menu");
        System.out.println("7. Exit");
        System.out.print("Enter an action to perform: ");
    }

    public static void main( String[] args )
    {

        //CLI implementation

        UniverseHashing universeHashing = new UniverseHashing();
        for(int i = 0; i < 100; i++)
        {
           universeHashing.newHashBase();
           System.out.println(universeHashing.getHashBase());
        }

        Scanner scanner = new Scanner(System.in);
        String tableChoice = "";
        String methodChoice = "";
        int tableSize = 0;
        printTableMenu();
        tableChoice = scanner.next();
        System.out.print("Enter the size of the hash table: ");
        tableSize = scanner.nextInt();
        DictionaryHandler dictionaryHandler = new DictionaryHandler(tableSize, tableChoice);
        if(dictionaryHandler != null)
        {
            System.out.println("Table created successfully");
        }

        while(true)
        {
            printActionMenu();
            methodChoice = scanner.next();
            dictionaryHandler.handleMethodChoice(methodChoice);
        }
    }
}

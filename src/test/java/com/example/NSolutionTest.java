package com.example;

import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class NSolutionTest
{
    @Test
    public void insertionTest()
    {
        NSolution hash_table = new NSolution(100);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertFalse(hash_table.insert("apple"));
    }

    @Test
    public void insertionDuplicate()
    {
        NSolution hash_table = new NSolution(100);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertFalse(hash_table.insert("apple"));
        assertFalse(hash_table.insert("banana"));
        assertFalse(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));
        assertFalse(hash_table.insert("orange"));
        assertFalse(hash_table.insert("grape"));
        assertFalse(hash_table.insert("watermelon"));
    }

    @Test
    public void insertionMultiple()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(1000);
        try
        {
            File file = new File("D:\\JavaProjects\\Perfect-Hashing-Data-Structure\\src\\main\\java\\com\\example\\testFiles\\1000.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                assertTrue(hash_table.insert(scanFile.nextLine()));
                countSuccessfulInsertions++;
            }
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
             e.printStackTrace();
        }
        assertEquals(1000, countSuccessfulInsertions);
    }

    @Test
    public void insertionHuge()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(10000);
        try
        {
            File file = new File("D:\\JavaProjects\\Perfect-Hashing-Data-Structure\\src\\main\\java\\com\\example\\testFiles\\10000.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                assertTrue(hash_table.insert(scanFile.nextLine()));
                countSuccessfulInsertions++;
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }

        assertEquals(9894, countSuccessfulInsertions);
    }

    @Test
    public void deletionTest(){
        NSolution hash_table = new NSolution(100);
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("cherry");
        assertTrue(hash_table.delete("apple"));
        assertFalse(hash_table.delete("apple"));
    }

    @Test
    public void SearchTest(){
        NSolution hash_table = new NSolution(100);
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("cherry");
        assertTrue(hash_table.search("apple"));
        assertFalse(hash_table.search("orange"));
    }

    @Test
    public void millionSearchTest()
    {
        NSolution hash_table = new NSolution(100000);
        //setup the table with 1 million words
        for (int i = 0; i < 100000; i++)
        {
            assertTrue(hash_table.insert(String.valueOf((i))));
        }
        //search for the words
        for (int i = 0; i < 100000; i++)
        {
            assertTrue(hash_table.search(String.valueOf((i))));
        }
        for(int i = 100000; i < 1000000; i++)
        {
            assertFalse(hash_table.search(String.valueOf((i))));
        }
    }

    @Test
    public void searchAndDelete(){
        NSolution hash_table = new NSolution(100);
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("cherry");
        assertTrue(hash_table.search("apple"));
        assertTrue(hash_table.delete("apple"));
        assertFalse(hash_table.search("apple"));
    }

    @Test
    public void hugeSearchAndDelete(){

        NSolution hash_table = new NSolution(10000);
        //setup the table with 10 thousand words
        for (int i = 0; i < 10000; i++)
        {
            assertTrue(hash_table.insert(String.valueOf((i))));
        }
        //search for the words
        for (int i = 0; i < 10000; i++)
        {
            assertTrue(hash_table.search(String.valueOf((i))));
        }
        //delete the words
        for (int i = 0; i < 10000; i++)
        {
            assertTrue(hash_table.delete(String.valueOf((i))));
        }
    }
}

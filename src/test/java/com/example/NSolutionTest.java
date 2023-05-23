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
    public void insertionTest2()
    {
        NSolution hash_table = new NSolution(2);
        assertTrue(hash_table.insert("l"));
        assertTrue(hash_table.insert("6"));
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
    public void insertFile()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(1000);
        try
        {
            File file = new File("D:\\JavaProjects\\Perfect-Hashing-Data-Structure\\testFiles\\1000.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                String word = scanFile.nextLine();
                if(hash_table.search(word)){
                    assertFalse(hash_table.insert(word));
                }else{
                    assertTrue(hash_table.insert(word));
                    countSuccessfulInsertions++;
                }
            }
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
             e.printStackTrace();
        }
        assertEquals(999, countSuccessfulInsertions);
    }

    @Test
    public void insertHugeFile1()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(5000);
        try
        {
            File file = new File("D:\\JavaProjects\\Perfect-Hashing-Data-Structure\\testFiles\\5000.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                String word = scanFile.nextLine();
                if(hash_table.search(word)){
                    assertFalse(hash_table.insert(word));
                }else{
                    assertTrue(hash_table.insert(word));
                    countSuccessfulInsertions++;
                }

            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }

        assertEquals(2122, countSuccessfulInsertions);
    }

    @Test
    public void insertHugeFile2()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(60000);
        try
        {
            File file = new File("D:\\JavaProjects\\Perfect-Hashing-Data-Structure\\testFiles\\58109.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                String word = scanFile.nextLine();
                if(hash_table.search(word)){
                    assertFalse(hash_table.insert(word));
                }else{
                    assertTrue(hash_table.insert(word));
                    countSuccessfulInsertions++;
                }

            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }

        assertEquals(58108, countSuccessfulInsertions);
    }

    @Test
    public void insertHugeFile3()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(400000);
        try
        {
            File file = new File("D:\\JavaProjects\\Perfect-Hashing-Data-Structure\\testFiles\\huge.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                String word = scanFile.nextLine();
                if(hash_table.search(word)){
                    assertFalse(hash_table.insert(word));
                }else{
                    assertTrue(hash_table.insert(word));
                    countSuccessfulInsertions++;
                }

            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }

        assertEquals(370104, countSuccessfulInsertions);
    }

    @Test
    public void insertHugeFile4()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(1200000);
        try
        {
            File file = new File("D:\\JavaProjects\\Perfect-Hashing-Data-Structure\\testFiles\\million.txt");
            Scanner scanFile = new Scanner(file);
            while(scanFile.hasNextLine())
            {
                String word = scanFile.nextLine();
                if(hash_table.search(word)){
                    assertFalse(hash_table.insert(word));
                }else{
                    assertTrue(hash_table.insert(word));
                    countSuccessfulInsertions++;
                }
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File not found");
            e.printStackTrace();
        }

        assertEquals(370104, countSuccessfulInsertions);
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
    public void hugeInsert1()
    {
        NSolution hash_table = new NSolution(1000000);
        for(int i = 0; i < 1000000; i++)
        {
            assertTrue(hash_table.insert(String.valueOf((i))));
        }
    }

    @Test
    public void hugeSearch1()
    {
        NSolution hash_table = new NSolution(10);
        for(int i = 0; i < 1000000; i++)
        {
            hash_table.search(String.valueOf((i)));
        }
    }

    @Test
    public void hugeSearch2()
    {
        NSolution hash_table = new NSolution(10);

        for(int i = 0; i < 500000; i++)
        {
            hash_table.search(String.valueOf((i)));
        }
    }
    @Test
    public void hugeSearch3()
    {
        NSolution hash_table = new NSolution(10);

        for(int i = 0; i < 100000; i++)
        {
            hash_table.search(String.valueOf((i)));
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

    @Test
    //number of times needed to rebuild the hash table in case of collision
    public void rebuildTest(){
        NSolution hash_table = new NSolution(100);
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("cherry");
        hash_table.insert("orange");
        hash_table.insert("grape");
//        assertThat(hash_table.getRebuildCount(), is(1));
    }

    @Test
    //test space of the hash table
    public void spaceTest(){
        NSolution hash_table = new NSolution(100);
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("cherry");
        hash_table.insert("orange");
        hash_table.insert("grape");
//        assertThat(hash_table.getSpace(), is(5));
    }
}

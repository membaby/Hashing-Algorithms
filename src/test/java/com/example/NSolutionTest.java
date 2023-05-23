package com.example;

import com.example.BackendPerfectHashing.NSolution;
import com.example.BackendPerfectHashing.NSquaredSolution;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
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
        assertTrue(hash_table.search("apple"));
        assertTrue(hash_table.search("banana"));
        assertTrue(hash_table.search("cherry"));
		
    }

	@Test
    public void insertionTest2()
    {
        NSolution hash_table = new NSolution(2);
        assertTrue(hash_table.insert("l"));
        assertTrue(hash_table.insert("6"));
        assertTrue(hash_table.search("l"));
        assertTrue(hash_table.search("6"));
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

        assertTrue(hash_table.search("apple"));
        assertTrue(hash_table.search("banana"));
        assertTrue(hash_table.search("cherry"));
        assertTrue(hash_table.search("orange"));
        assertTrue(hash_table.search("grape"));
        assertTrue(hash_table.search("watermelon"));
    }

    @Test
    public void insertFile()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(1000);
        try
        {
            File file = new File("testFiles/1000.txt");
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
			assertEquals(999, countSuccessfulInsertions);
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
             e.printStackTrace();
			 assertTrue(false);
        }
    }

    @Test
    public void insertHugeFile1()
    {
        int countSuccessfulInsertions = 0 ;
        NSolution hash_table = new NSolution(5000);
        try
        {
            File file = new File("testFiles/5000.txt");
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
            File file = new File("testFiles/58109.txt");
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
            File file = new File("testFiles/huge.txt");
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
            File file = new File("testFiles/million.txt");
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
	public void insert500()
	{
		HashSet<String> refSet = new HashSet<String>(500);
		NSolution mySet = new NSolution(500);
		try{
			File file = new File("comparisonFiles/500.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}

	@Test
	public void insert1000()
	{
		HashSet<String> refSet = new HashSet<String>(1000);
		NSolution mySet = new NSolution(1000);
		try{
			File file = new File("comparisonFiles/1000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}

	@Test
	public void insert5000()
	{
		HashSet<String> refSet = new HashSet<String>(5000);
		NSolution mySet = new NSolution(5000);
		try{
			File file = new File("comparisonFiles/5000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}

	@Test
	public void insert10000()
	{
		HashSet<String> refSet = new HashSet<String>(10000);
		NSolution mySet = new NSolution(10000);
		try{
			File file = new File("comparisonFiles/10000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}

	@Test
	public void insert50000()
	{
		HashSet<String> refSet = new HashSet<String>(50000);
		NSolution mySet = new NSolution(50000);
		try{
			File file = new File("comparisonFiles/50000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}

	@Test
	public void insert100000()
	{
		HashSet<String> refSet = new HashSet<String>(100000);
		NSolution mySet = new NSolution(100000);
		try{
			File file = new File("comparisonFiles/100000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}

	@Test
	public void insert1000000()
	{
		HashSet<String> refSet = new HashSet<String>(1000000);
		NSolution mySet = new NSolution(1000000);
		try{
			File file = new File("comparisonFiles/1000000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}

	@Test
	public void insert2000000()
	{
		HashSet<String> refSet = new HashSet<String>(2000000);
		NSolution mySet = new NSolution(2000000);
		try{
			File file = new File("comparisonFiles/2000000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
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

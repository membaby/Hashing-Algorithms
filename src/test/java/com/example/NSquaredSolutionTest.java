package com.example;

import com.example.BackendPerfectHashing.NSquaredSolution;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class NSquaredSolutionTest
{
    @Test
    public void simple_insertion_test()
    {
        NSquaredSolution hash_table = new NSquaredSolution(10);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
		
    }

    @Test
    public void insertion_duplicate_test()
    {
        NSquaredSolution hash_table = new NSquaredSolution(50);
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
    public void simple_search_test()
    {
        NSquaredSolution hash_table = new NSquaredSolution(50);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));
		
        assertTrue(hash_table.search("apple"));
        assertTrue(hash_table.search("banana"));
        assertTrue(hash_table.search("cherry"));
        assertTrue(hash_table.search("orange"));
        assertTrue(hash_table.search("grape"));
        assertTrue(hash_table.search("watermelon"));
    }
	
    @Test
    public void simple_search_test2()
    {
        NSquaredSolution hash_table = new NSquaredSolution(50);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));
		
        assertFalse(hash_table.search("book"));
        assertFalse(hash_table.search("car"));
        assertFalse(hash_table.search("tree"));
        assertFalse(hash_table.search("door"));
        assertFalse(hash_table.search("transport"));
        assertFalse(hash_table.search("Specific"));
    }

    @Test
    public void delete_test()
    {
        NSquaredSolution hash_table = new NSquaredSolution(50);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));
		
        assertTrue(hash_table.delete("apple"));
        assertTrue(hash_table.delete("banana"));
        assertTrue(hash_table.delete("cherry"));
        assertTrue(hash_table.delete("orange"));
        assertTrue(hash_table.delete("grape"));
        assertTrue(hash_table.delete("watermelon"));
		
    }
	
    @Test
    public void search_deleted_key_test()
    {
        NSquaredSolution hash_table = new NSquaredSolution(50);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));
		
        assertTrue(hash_table.delete("apple"));
        assertTrue(hash_table.delete("banana"));
        assertTrue(hash_table.delete("cherry"));
        assertTrue(hash_table.delete("orange"));
        assertTrue(hash_table.delete("grape"));
        assertTrue(hash_table.delete("watermelon"));
		
        assertFalse(hash_table.search("apple"));
        assertFalse(hash_table.search("banana"));
        assertFalse(hash_table.search("cherry"));
        assertFalse(hash_table.search("orange"));
        assertFalse(hash_table.search("grape"));
        assertFalse(hash_table.search("watermelon"));
		
    }
	
    @Test
    public void delete_test2()
    {
        NSquaredSolution hash_table = new NSquaredSolution(50);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));
		
        assertFalse(hash_table.delete("book"));
        assertFalse(hash_table.delete("car"));
        assertFalse(hash_table.delete("tree"));
        assertFalse(hash_table.delete("door"));
        assertFalse(hash_table.delete("transport"));
        assertFalse(hash_table.delete("Specific"));
    }
	
    @Test
    public void duplicate_delete_test()
    {
        NSquaredSolution hash_table = new NSquaredSolution(10);
		
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));

		assertTrue(hash_table.delete("apple"));
        assertTrue(hash_table.delete("banana"));
        assertTrue(hash_table.delete("cherry"));
        assertTrue(hash_table.delete("orange"));
        assertTrue(hash_table.delete("grape"));
        assertTrue(hash_table.delete("watermelon"));

		assertFalse(hash_table.delete("apple"));
        assertFalse(hash_table.delete("banana"));
        assertFalse(hash_table.delete("cherry"));
        assertFalse(hash_table.delete("orange"));
        assertFalse(hash_table.delete("grape"));
        assertFalse(hash_table.delete("watermelon"));
    }
	
    @Test
    public void insert_deleted_key_test()
    {
        NSquaredSolution hash_table = new NSquaredSolution(10);
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));

		assertTrue(hash_table.delete("apple"));
        assertTrue(hash_table.delete("banana"));
        assertTrue(hash_table.delete("cherry"));
        assertTrue(hash_table.delete("orange"));
        assertTrue(hash_table.delete("grape"));
        assertTrue(hash_table.delete("watermelon"));
    }
	
    @Test
    public void tight_insert()
    {
        NSquaredSolution hash_table = new NSquaredSolution(3);
        assertTrue(hash_table.insert("orange"));
        assertTrue(hash_table.insert("grape"));
        assertTrue(hash_table.insert("watermelon"));

        assertTrue(hash_table.search("orange"));
        assertTrue(hash_table.search("grape"));
        assertTrue(hash_table.search("watermelon"));
    }

    @Test
    public void insert_10000()
    {
        NSquaredSolution hash_table = new NSquaredSolution(10000);
        try
        {
            File file = new File("testFiles/10000.txt");
            Scanner scn = new Scanner(file);
            while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertTrue(hash_table.insert(word));
            }
			scn.close();
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
			 assertTrue(false);
        }
    }

    @Test
    public void search_10000()
    {
        NSquaredSolution hash_table = new NSquaredSolution(10000);
        try
        {
            File file = new File("testFiles/10000.txt");
            Scanner scn = new Scanner(file);
            while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertTrue(hash_table.insert(word));
            }
			scn.close();
			scn = new Scanner(file);
			while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertTrue(hash_table.search(word));
            }
			scn.close();
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
			 assertTrue(false);
        }
    }

    @Test
    public void delete_10000()
    {
        NSquaredSolution hash_table = new NSquaredSolution(10000);
        try
        {
            File file = new File("testFiles/10000.txt");
            Scanner scn = new Scanner(file);
            while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertTrue(hash_table.insert(word));
            }
			scn.close();
			scn = new Scanner(file);
			while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertTrue(hash_table.delete(word));
            }
			scn.close();
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
			 assertTrue(false);
        }
    }

    @Test
    public void random_search_filled()
    {
        NSquaredSolution mySet = new NSquaredSolution(10000);
		HashSet<String> refSet = new HashSet<String>(10000);

        try
        {
            File file = new File("testFiles/10000.txt");
            Scanner scn = new Scanner(file);
            while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertTrue(mySet.insert(word));
				refSet.add(word);
            }
			scn.close();
			File searchF = new File("comparisonFiles/200000.txt");
			scn = new Scanner(searchF);
			while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertEquals(mySet.search(word), refSet.contains(word));
            }
			scn.close();
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
			 assertTrue(false);
        }
    }

    @Test
    public void random_delete_filled()
    {
        NSquaredSolution mySet = new NSquaredSolution(10000);
		HashSet<String> refSet = new HashSet<String>(10000);

        try
        {
            File file = new File("testFiles/10000.txt");
            Scanner scn = new Scanner(file);
            while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertTrue(mySet.insert(word));
				refSet.add(word);
            }
			scn.close();
			File searchF = new File("comparisonFiles/200000.txt");
			scn = new Scanner(searchF);
			while(scn.hasNextLine())
            {
                String word = scn.nextLine();
				assertEquals(mySet.delete(word), refSet.remove(word));
				assertFalse(mySet.search(word));
            }
			scn.close();
        }
        catch(FileNotFoundException e)
        {
             System.out.println("File not found");
			 assertTrue(false);
        }
    }

    @Test
    public void insert_file_with_duplicates()
    {
        int countSuccessfulInsertions = 0 ;
        NSquaredSolution hash_table = new NSquaredSolution(5000);
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
    public void insertionHuge()
    {
        int countSuccessfulInsertions = 0 ;
        NSquaredSolution hash_table = new NSquaredSolution(5000);
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
	public void insert10000()
	{
		HashSet<String> refSet = new HashSet<String>(10000);
		NSquaredSolution mySet = new NSquaredSolution(10000);
		try{
			File file = new File("comparisonFiles/10000.txt");
            Scanner scn = new Scanner(file);
			while(scn.hasNext())
			{
				String next = scn.next();
				assertEquals(refSet.add(next), mySet.insert(next));
			}
			for (String string : refSet) {
				assertTrue(mySet.search(string));
			}
		} catch (FileNotFoundException e){assertTrue(false);}
	}
}

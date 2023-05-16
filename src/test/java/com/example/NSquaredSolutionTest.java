package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import com.example.BackendPerfectHashing.NSquaredSolution;

public class NSquaredSolutionTest
{
    @Test
    public void insertionTest()
    {
        NSquaredSolution hash_table = new NSquaredSolution();
        assertTrue(hash_table.insert("apple"));
        assertTrue(hash_table.insert("banana"));
        assertTrue(hash_table.insert("cherry"));
        assertFalse(hash_table.insert("apple"));
    }

    @Test
    public void deletionTest(){
        NSquaredSolution hash_table = new NSquaredSolution();
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("cherry");
        assertTrue(hash_table.delete("apple"));
        assertFalse(hash_table.delete("apple"));
    }

    @Test
    public void SearchTest(){
        NSquaredSolution hash_table = new NSquaredSolution();
        hash_table.insert("apple");
        hash_table.insert("banana");
        hash_table.insert("cherry");
        assertTrue(hash_table.search("apple"));
        assertFalse(hash_table.search("orange"));
    }
}

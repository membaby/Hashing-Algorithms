package com.example;

import org.junit.Test;

import com.example.ApplicationsOnHashing.EnglishDictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.Assert.*;

public class EnglishDictionaryTest {
	

	@Test
	public void insert_test()
	{
		EnglishDictionary dict = new EnglishDictionary("1", 3);
		assertTrue(dict.insert("apple"));
		assertTrue(dict.insert("tree"));
		assertTrue(dict.insert("wheel"));

	}

	@Test
	public void insert_duplicate_test()
	{
		EnglishDictionary dict = new EnglishDictionary("1", 4);
		assertTrue(dict.insert("apple"));
		assertTrue(dict.insert("tree"));
		assertTrue(dict.insert("wheel"));
		assertFalse(dict.insert("apple"));

	}
	
	@Test
	public void search_test()
	{
		EnglishDictionary dict = new EnglishDictionary("2", 3);
		assertTrue(dict.insert("apple"));
		assertTrue(dict.insert("tree"));
		assertTrue(dict.insert("wheel"));
		
		assertTrue(dict.search("apple"));
		assertTrue(dict.search("tree"));
		assertTrue(dict.search("wheel"));

	}
	
	@Test
	public void search_test2()
	{
		EnglishDictionary dict = new EnglishDictionary("2", 3);
		assertTrue(dict.insert("apple"));
		assertTrue(dict.insert("tree"));
		assertTrue(dict.insert("wheel"));

	}

	@Test
	public void delete_test()
	{
		EnglishDictionary dict = new EnglishDictionary("1", 3);
		assertTrue(dict.insert("apple"));
		assertTrue(dict.insert("tree"));
		assertTrue(dict.insert("wheel"));

		assertTrue(dict.delete("apple"));
		assertTrue(dict.delete("tree"));
		assertTrue(dict.delete("wheel"));

	}

	@Test
	public void delete_test2()
	{
		EnglishDictionary dict = new EnglishDictionary("2", 3);
		assertTrue(dict.insert("apple"));
		assertTrue(dict.insert("tree"));
		assertTrue(dict.insert("wheel"));
		
		assertFalse(dict.delete("orange"));
		assertFalse(dict.delete("car"));
		assertTrue(dict.delete("wheel"));

	}

	@Test
	public void batch_insert_test()
	{
		EnglishDictionary dict = new EnglishDictionary("2", 10000);
		assertEquals(dict.batchInsert("comparisonFiles/10000.txt"), 10001);
	}

	@Test
	public void batch_delete_test()
	{
		EnglishDictionary dict = new EnglishDictionary("2", 10000);
		assertEquals(dict.batchInsert("comparisonFiles/10000.txt"), 10001);
		
		assertEquals(dict.batchDelete("comparisonFiles/10000.txt"), 10001);

	}

}

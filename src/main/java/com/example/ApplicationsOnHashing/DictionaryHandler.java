package com.example.ApplicationsOnHashing;

import java.util.Scanner;

public class DictionaryHandler
{
    private EnglishDictionary englishDictionary;
    public DictionaryHandler(int tableSize, String hashTable)
    {
        englishDictionary = new EnglishDictionary(hashTable, tableSize);
    }

    public void handleMethodChoice(String methodChoice){
        Scanner scanner = new Scanner(System.in);
        switch (methodChoice)
        {
            case "1":
                System.out.println("Enter the word to insert: ");
                String word = scanner.next();
                if (englishDictionary.insert(word)) {
                    System.out.println("Word inserted successfully");
                } else {
                    System.out.println("Word already exists");
                }
                break;
            case "2":
                System.out.println("Enter the word to delete: ");
                word = scanner.next();
                if (englishDictionary.delete(word)) {
                    System.out.println("Word deleted successfully");
                } else {
                    System.out.println("Word doesn't exist");
                }
                break;

            case "3":
                System.out.println("Enter the word to search for: ");
                word = scanner.next();
                if (englishDictionary.search(word)) {
                    System.out.println("Word found");
                } else {
                    System.out.println("Word not found");
                }
                break;
            case "4":
                System.out.println("Enter the path of the file to insert: ");
                String filePath = scanner.next();
                int count = englishDictionary.batchInsert(filePath);
                System.out.println(count + " words inserted successfully");
                break;
            case "5":
                System.out.println("Enter the path of the file to delete: ");
                filePath = scanner.next();
                count = englishDictionary.batchDelete(filePath);
                System.out.println(count + " words deleted successfully");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}

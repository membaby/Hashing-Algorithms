package com.example.ApplicationsOnHashing;

public interface IDictionary {
    boolean insert(String word);
    boolean delete(String word);
    boolean search(String word);
    int batchInsert(String filePath);
    int batchDelete(String filePath);
}

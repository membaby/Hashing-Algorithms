package com.example.ApplicationsOnHashing;

public interface IDictionary {
    boolean insert(String word);
    boolean delete(String word);
    boolean search(String word);
    void batchInsert(String filePath);
    void batchDelete(String filePath);
}

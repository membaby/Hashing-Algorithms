package com.example.BackendPerfectHashing;

public interface IPerfectHash {
    boolean insert(String item);
    boolean delete(String item);
    boolean search(String item);
}

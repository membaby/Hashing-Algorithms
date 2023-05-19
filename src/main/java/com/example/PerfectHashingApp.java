package com.example;

import com.example.BackendPerfectHashing.UniverseHashing;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class PerfectHashingApp
{
    public static void main( String[] args )
    {
        UniverseHashing universeHashing = new UniverseHashing();
        String binaryString = universeHashing.hash_string("hello");
        System.out.println(binaryString);
        String hx = universeHashing.hash(binaryString, 100);
        universeHashing.setHashString(hx);
        for(int i = 0 ; i < 100 ; i ++)
        {
            //test that getters and setters works just fine
            System.out.println(universeHashing.getHashString());
        }
    }
}

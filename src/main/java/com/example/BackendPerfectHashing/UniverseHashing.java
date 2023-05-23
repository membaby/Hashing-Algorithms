package com.example.BackendPerfectHashing;

import java.util.Arrays;

public class UniverseHashing
{
    private int u = 64 ;
    private int b = 0 ;
    private int[][] currentHashMatrix;
    private int tableSize;
    private int hashBase = 31;

    public int[][] getHashMatrix()
    {
        return this.currentHashMatrix;
    }

    public int getHashBase()
    {
        return this.hashBase;
    }

    private boolean isPrime(int n)
    {
        for(int i = 1 ; i < n ; i++)
        {
            if(n % i == 0 && i != 1)
            {
                return false;
            }
        }
        return true;
    }

    public void newHashBase()
    {
        int test = 0 ;
        //make prime hash base
        while(true)
        {
            test = (int) (Math.random() * 256  + 1);
            if(isPrime(test))
            {
                this.hashBase = test;
                break;
            }
        }
    }

    public void newHashMatrix(int tableSize)
    {
        //number of rows | index size
        this.tableSize = tableSize;
        int b = (int) Math.max(1, Math.ceil(Math.log(tableSize) / Math.log(2)));
        this.b = b ;
        int[][] hashMatrix = new int[b][u];

        //construct the hash matrix
        for(int i = 0 ; i < b ; i ++)
        {
            for(int j = 0 ; j < u ; j++)
            {
                hashMatrix[i][j] = (int) (Math.random() * 2);
            }
        }
        this.currentHashMatrix = hashMatrix;
    }

    public String hash_string(String str)
    {
        long code = 1;
        for (int i=0; i < str.length(); i++)
        {
            code = code * this.hashBase + str.charAt(i);
        }
        return Long.toBinaryString(code);
    }

    public int hash(int[][] hashMatrix, String binaryString)
    {
        int[] hx = new int[this.b];
        //construct the hx | array of hash digest
        for(int i = 0 ; i < binaryString.length() ; i ++)
        {
            if(binaryString.charAt(i) == '1')
            {
                for(int j = 0 ; j < this.b ; j++)
                {
                    hx[j] = (hx[j] + hashMatrix[j][i]) % 2;
                }
            }
        }

        //return the hash digest to caller
        String digest = "";
        for(int i = 0 ; i < this.b ; i ++)
        {
            digest += hx[i];
        }

        return Integer.parseInt(digest, 2) % this.tableSize;
    }
}







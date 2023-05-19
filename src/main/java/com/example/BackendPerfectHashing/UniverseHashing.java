package com.example.BackendPerfectHashing;

import java.util.Arrays;

public class UniverseHashing
{
    private int u = 64 ;
    private String hashString = "";

    public void setHashString(String hashString) {
        this.hashString = hashString;
    }

    public String getHashString() {
        return hashString;
    }

    public String hash_string(String str)
    {
        long code = 0;
        for (int i=0; i < str.length(); i++)
        {
            code += str.charAt(i)*Math.pow(128, i);
        }
        return Long.toBinaryString(code);
    }

    public String hash(String binaryString , int tableSize)
    {

        //number of rows | index size
        int b = (int) Math.ceil(Math.log(tableSize) / Math.log(2));
        int[][] hashMatrix = new int[b][u];

        //construct the hash matrix
        for(int i = 0 ; i < b ; i ++)
        {
            for(int j = 0 ; j < u ; j++)
            {
                hashMatrix[i][j] = (int) (Math.random() * 2);
            }
        }

        int[] hx = new int[b];
        //construct the hx | array of hash digest
        for(int i = 0 ; i < binaryString.length() ; i ++)
        {
            if(binaryString.charAt(i) == '1')
            {
                for(int j = 0 ; j < b ; j++)
                {
                    hx[j] = (hx[j] + hashMatrix[j][i]) % 2;
                }
            }
        }

        //return the hash digest to caller
        String digest = "";
        for(int i = 0 ; i < b ; i ++)
        {
            digest += hx[i];
        }

        return digest;
    }
}







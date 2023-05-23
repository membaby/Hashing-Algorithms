package com.example.BackendPerfectHashing;

import java.util.Random;

public class UniverseHashing
{
    private int u = 64;
    private int b = 0 ;
	private long[] hashMatrix;
    // private int[][] currentHashMatrix;
    private int tableSize;
    private int hashBase = 31;
	private int[] primes = {31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127};

    public long[] getHashMatrix()
    {
        return hashMatrix;
    }

    public int getHashBase()
    {
        return hashBase;
    }

    public void newHashBase() {
		Random rand = new Random();
		int oldBase = hashBase;
		while (hashBase == oldBase){
			hashBase = primes[rand.nextInt(primes.length)];
		}
    }

    public void newHashMatrix(int tableSize)
    {
        //number of rows | index size
        this.tableSize = tableSize;
        int b = (int) Math.max(1, Math.ceil(Math.log(tableSize) / Math.log(2)));
        this.b = b ;
        long[] hashMatrix = new long[b];
		Random rand = new Random();

        //construct the hash matrix
        for(int i = 0 ; i < b ; i ++)
        {
			hashMatrix[i] = rand.nextLong();
        }
        this.hashMatrix = hashMatrix;
    }

    public long hash_string(String str)
    {
        long code = 0;
        for (int i=0; i < str.length(); i++)
        {
            code = code * hashBase + str.charAt(i);
        }
        return code;
    }

    public int hash(long num)
    {
        int[] hx = new int[hashMatrix.length];
        //construct the hx | array of hash digest
        for(int row=0 ; row<hashMatrix.length; row++)
        {
			long multRes = hashMatrix[row] & num;
			int accum = 0;
			if (multRes < 0)
			{
				multRes = multRes & Long.MAX_VALUE;
				accum++;
			}
			if (multRes < 0) {System.out.println("Mat Mult Res is still negative. This is wrong.");}
			while (multRes != 0){
				if ((multRes & 1) == 1) accum++;
				multRes >>= 1;
			}
			hx[row] = accum%2;
        }

        int result = 0;
		for(int i=0; i<hx.length; i++){
			result = (result << 1) + hx[i];
		}

        return result % tableSize;
    }
}







package com.example.BackendPerfectHashing;

public class UniverseHashing
{

    public String hash_string(String str)
    {
        long code = 0;
        for (int i=0; i < str.length(); i++)
        {
            code += str.charAt(i)*Math.pow(128, i);
        }
        return Long.toBinaryString(code);
    }

}


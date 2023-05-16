package com.example.BackendPerfectHashing;

public abstract class IPerfectHash {
    abstract boolean insert(String item);
    abstract boolean delete(String item);
    abstract boolean search(String item);

	private int hash_string(String str){
		int code = 0;
		for (int i=0; i < str.length(); i++) 
		{
			code += str.charAt(i)*Math.pow(128, i);	
		}

		return code;
	}
}

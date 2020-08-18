package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String N = br.readLine();
			if( N.equals("0")) break;
			if(check(N))
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
	
	public static boolean check(String n) {
		String now = n;
		n = new StringBuffer(n).reverse().toString();
		if(n.equals(now))
			return true;
		return false;
	}
}

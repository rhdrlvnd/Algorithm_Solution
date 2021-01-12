package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011_암호코드_210112 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] input = br.readLine().toCharArray();
		int[] N = new int[input.length+1];

		for (int i = 0; i < input.length; i++) {
			N[i+1] = input[i] - '0';
		}

		int[] dp = new int[N.length];
		
		dp[0] = 1;
		
		for (int i = 1; i < N.length; i++) {
			if (N[i] != 0) {
				dp[i] = (dp[i - 1] + dp[i]) % 1000000;
			}
			int x = N[i] + N[i - 1] * 10;
			if (10 <= x && x <= 26) {
				dp[i] = (dp[i - 2] + dp[i]) % 1000000;
			}
		}
		System.out.println(dp[N.length - 1]);
	}

}

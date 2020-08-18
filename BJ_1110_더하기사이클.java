package com.ssafy;

import java.util.Scanner;

public class BJ_1110_더하기사이클 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = 0;
		int var = N;
		while(true) {
			var = do_sum(var);
			cnt++;
			if(N == var) {
				System.out.println(cnt);
				break;
			}
		}
	}
	
	public static int do_sum(int N) {
		int ten = N/10;
		int one = N%10;
		int sum = ten + one;
		int result = (10*one) + (sum%10);
		return result;
	}
}

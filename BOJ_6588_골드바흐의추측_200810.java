package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6588_골드바흐의추측_200810 {

	static int[] arr = new int[1000001];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		makeArr();
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			check(N);
		}
	}

	public static void makeArr() {
		for (int i = 2; i < 1000000; i++) {
			int now = i;
			if (arr[i] != 1) {
				while (true) {
					if(now+i <1000000) {
						now += i;
						arr[now] = 1;
					}else
						break;
				}
			}
		}
	}

	public static void check(int n) {
		for (int i = 3; i < 500000; i++) {
			if (arr[i] == 0) {
				if (arr[n - i] == 0) {
					System.out.println(n + " = " + i + " + " + (n - i));
					return;
				}
			}
		}
	}

}

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기_200808 {

	static boolean[] visit = new boolean[1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		check();
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if(visit[cur] == false) cnt++;
		}
		
		System.out.println(cnt);
	}

	public static void check() {
		visit[1] = true;
		for(int i = 2; i < 1001; i++) {
			int num = i;
			while(true) {
				num += i;
				if(num > 1000) break;
				visit[num] = true;
				
			}
		}
	}
}

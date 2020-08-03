package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이와SpotMart {
	
	static int[] Cookie;
	static int MAX;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Cookie = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				Cookie[i] = Integer.parseInt(st.nextToken());
			}
			MAX = -1;
			dfs(0, M, 0, 1);
			System.out.println(MAX);
		}

	}
	
	public static void dfs(int x, int M, int current, int cnt) {
		current += Cookie[x];
		
		if(current > M) {
			return;
		}
		
		if(cnt == 2 && MAX < current) {
			MAX = current;
		}
		if(x +1 == N)
			return;
		dfs(x+1, M, current, cnt+1);
		dfs(x+1, M, current-Cookie[x], cnt);
		
		return;
	}

}

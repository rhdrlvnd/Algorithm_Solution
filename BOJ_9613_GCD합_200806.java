package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613_GCD합_200806 {
	
	static long ans, N;
	static int[] sum_arr;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			ans = 0;
			arr = new int[2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[(int)N];
			sum_arr = new int[2];
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			System.out.println(ans);
		}

	}
	
	public static int GCD(int x, int y) {
		if(y == 0)
			return x;
		return GCD(y, x%y);
	}
	
	public static void dfs(int x, int cnt) {
		if(cnt == 2 || x >= N) return;
		sum_arr[cnt] = arr[x];
		if(cnt == 1) 
			ans += GCD(sum_arr[0], sum_arr[1]);
		dfs(x+1, cnt+1);
		dfs(x+1, cnt);
	}
}

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식_200806 {

	static int ans;
	static Food[] foodList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		foodList = new Food[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			foodList[i] = new Food(x, y);
		}
		ans = 1000000000;
		dfs(0, 1, 0);
		System.out.println(ans);

	}
	
	public static void dfs (int index, int x, int y) {
		if(index >= foodList.length) return;
		Food now = foodList[index];
		int nx = x*now.x;
		int ny = y+ now.y;
		if(ans > Math.abs(nx-ny)) {
			ans = Math.abs(nx-ny);
		}
		dfs(index+1, nx, ny);
		dfs(index+1, x, y);
	}
	
	static class Food{
		int x;
		int y;
		
		public Food(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

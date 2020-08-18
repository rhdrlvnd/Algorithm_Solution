package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬_200810 {

	static int[][] map;
	static boolean[][] visit;
	static LinkedList<Point> q;
	static int N, M, ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j = 0; j < M; j++) {
				map[i][j] = arr[j] - 'L';
			}
		}
		ans = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					bfs(i, j, 0);
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void bfs(int x, int y, int cnt) {
		q = new LinkedList<Point>();
		visit = new boolean[N][M];
		visit[x][y] = true;
		q.offer(new Point(x, y, cnt));
		int max = 0;
		while(!q.isEmpty()) {
			Point now = q.poll();
			max = now.cnt;
			if((now.x-1) >= 0) {
				if(map[now.x-1][now.y] == 0 && visit[now.x-1][now.y] == false) {
					visit[now.x-1][now.y] = true;
					q.offer(new Point(now.x-1, now.y, now.cnt+1));
				}
			}
			if(now.y -1 >= 0) {
				if(map[now.x][now.y-1] == 0 && visit[now.x][now.y-1] == false) {
					visit[now.x][now.y-1] = true;
					q.offer(new Point(now.x, now.y-1, now.cnt+1));
				}
			}
			if(now.x +1 < N) {
				if(map[now.x+1][now.y] == 0 && visit[now.x+1][now.y] == false) {
					visit[now.x+1][now.y] = true;
					q.offer(new Point(now.x+1, now.y, now.cnt+1));
				}
			}
			if(now.y +1 < M) {
				if(map[now.x][now.y+1] == 0 && visit[now.x][now.y+1] == false) {
					visit[now.x][now.y+1] = true;
					q.offer(new Point(now.x, now.y+1, now.cnt+1));
				}
			}
		}
		if(ans < max)
			ans = max;
	}
	
	static class Point{
		int x;
		int y;
		int cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}

}

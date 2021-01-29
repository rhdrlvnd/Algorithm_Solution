package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			while(true) {
				boolean isEnd = false;
				for (int i = 0; i < map.length; i++) {
					if(map[i][N-1] > 0) {
						hit(i, N-1, map);
						isEnd = true;
						break;
					}
				}
				
				if(!isEnd) break;
				reMap(map);
				
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				System.out.println("--------------");
			}
			
			
		}
	}

	private static void reMap(int[][] map) {
		for (int i = 0; i < map[0].length; i++) {
			for (int j = map.length - 1; j > 0; j--) {
				if(map[j][i] == 0) {
					for (int j2 = j-1; j2 >= 0; j2--) {
						if(map[j2][i] > 0) {
							map[j][i] = map[j2][i];
							map[j2][i] = 0;
							break;
						}
					}
				}
			}
		}
		
	}

	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	private static void hit(int x, int y, int[][] map) {
		LinkedList<Point> q =new LinkedList<Point>();
		q.offer(new Point(x, y, map[x][y]));
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			map[now.x][now.y] = 0;
			if(now.cnt > 1){
				for (int i = 1; i < now.cnt; i++) {
					for (int j = 0; j < dr.length; j++) {
						int nx = now.x + (dr[j]*i);
						int ny = now.y + (dc[j]*i);
						if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[nx].length) continue;
						if(map[nx][ny] > 0) 
							q.offer(new Point(nx, ny, map[nx][ny]));
					}
				}
			}
		}
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

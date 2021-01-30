package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2580_스도쿠 {

	static int[][] map;
	static boolean[] visit;
	static ArrayList<Point> pList;
	static boolean clear;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[9][9];
		visit = new boolean[9];
		pList = new ArrayList<Point>();
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					pList.add(new Point(i, j));
				}
			}
		}

		dfs(0);

	}

	public static void dfs(int index) {
		if (index == pList.size()) {
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		Point now = pList.get(index);
		for (int i = 1; i <= 9; i++) {
			check(now.x, now.y, i);
			if (clear) {
				map[now.x][now.y] = i;
				dfs(index + 1);
				map[now.x][now.y] = 0;
			}
		}
	}

	public static void check(int x, int y, int n) {
		clear = true;
		for (int i = 0; i < map.length; i++) {
			if (map[x][i] == n)
				clear = false;
		}

		if (clear) {
			for (int i = 0; i < map.length; i++) {
				if (map[i][y] == n)
					clear = false;
			}
		}

		if (clear) {
			x = x / 3;
			y = y / 3;
			for (int xx = x * 3; xx < (x * 3) + 3; xx++) {
				for (int yy = y * 3; yy < (y * 3) + 3; yy++) {
					if (map[xx][yy] == n)
						clear = false;
				}
			}
		}
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}

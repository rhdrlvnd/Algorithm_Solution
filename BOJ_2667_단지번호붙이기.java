package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2667_단지번호붙이기 {
	static int[][] map;
	static int[][] visit;
	static int[] cnt;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		cnt = new int[N*N];
		for (int i = 0; i < N; i++) {
			char[] S = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = S[j] -'0';
			}
		}
		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visit[i][j] == 0) {
					visit[i][j] = 1;
					check(i, j);
					cnt[ans]++;
					ans++;
				}
			}
		}
		System.out.println(ans);
		Arrays.sort(cnt);
		for(int i = (N*N-ans); i < N*N; i++) {
			System.out.println(cnt[i]);
		}
	}

	// 상 하 좌 우
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void check(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[nx].length && visit[nx][ny] == 0
					&& map[nx][ny] == 1) {
				visit[nx][ny] = 1;
				cnt[ans]++;
				check(nx, ny);
			}
		}
	}

}

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {

	static int N, M;
	static int[][] map;
	static int[][] cnt;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		cnt = new int[N - 7][M - 7];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - 'B';
			}
		}
		
		ans = 64;
		for (int i = 0; i < cnt.length; i++) {
			for (int j = 0; j < cnt[i].length; j++) {
				check(i, j);
			}
		}
		System.out.println(ans);
	}

	public static void check(int x, int y) {
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if ((i + j) % 2 == 0 && map[i][j] == 0) {
					cnt[x][y]++;
				} else if ((i + j) % 2 != 0 && map[i][j] != 0) {
					cnt[x][y]++;
				}
			}
		}

		if (cnt[x][y] > 32) {
			cnt[x][y] = 64 - cnt[x][y];
		}
		if(ans > cnt[x][y])
			ans = cnt[x][y];
	}

}

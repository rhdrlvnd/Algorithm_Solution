package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {

	static int R, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Shark[][] map = new Shark[R+1][C+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(d == 1 || d == 2)
				s = s %(2*(R-1));
			else
				s = s %(2*(C-1));
			int z = Integer.parseInt(st.nextToken());
			if(map[r][c] == null || map[r][c].z < z)
				map[r][c] = new Shark(s, d, z);
		}
		
		int ans = 0;
		int cnt = 0;
		while(cnt++ < C) {
			for (int i = 1; i < map.length; i++) {
				if(map[i][cnt] != null) {
					ans += map[i][cnt].z;
					map[i][cnt] = null;
					break;
				}
			}
			map = moveShark(map);
		}
		System.out.println(ans);
	}

	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, 1, -1};
	
	private static Shark[][] moveShark(Shark[][] map) {
		Shark[][] temp = new Shark[R+1][C+1];
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if(map[i][j] != null) {
					int nx = i;
					int ny = j;
					for (int s = 0; s < map[i][j].s; s++) {
						nx += dr[map[i][j].d];
						ny += dc[map[i][j].d];
						if(nx < 1 || ny < 1 || nx > R || ny > C) {
							switch (map[i][j].d) {
							case 1:
								map[i][j].d = 2;
								break;
							case 2:
								map[i][j].d = 1;
								break;
							case 3:
								map[i][j].d = 4;
								break;
							case 4:
								map[i][j].d = 3;
								break;
							}
							nx += 2*dr[map[i][j].d];
							ny += 2*dc[map[i][j].d];
						}
					}
					if(temp[nx][ny] == null || temp[nx][ny].z < map[i][j].z) {
						temp[nx][ny] = map[i][j];
					}
				}
			}
		}
		return temp;
	}

	static class Shark{
		int s;
		int d;
		int z;
		public Shark(int s, int d, int z) {
			super();
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}

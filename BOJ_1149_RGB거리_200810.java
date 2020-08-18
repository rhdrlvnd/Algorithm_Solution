package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리_200810 {

	static int[][] RGB, d;
	static int ans, N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		RGB = new int[N][3];
		d = new int[N][3];
		ans = 1000000;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			RGB[i][0] = Integer.parseInt(st.nextToken());
			RGB[i][1] = Integer.parseInt(st.nextToken());
			RGB[i][2] = Integer.parseInt(st.nextToken());
		}
		d[0][0] = RGB[0][0];
		d[0][1] = RGB[0][1];
		d[0][2] = RGB[0][2];
		for(int i = 1; i < N; i++) {
			d[i][0] = Math.min(d[i-1][1], d[i-1][2])+ RGB[i][0];
			d[i][1] = Math.min(d[i-1][0], d[i-1][2])+ RGB[i][1];
			d[i][2] = Math.min(d[i-1][1], d[i-1][0])+ RGB[i][2];
		}
		System.out.println(Math.min(d[N-1][0], Math.min(d[N-1][1], d[N-1][2])));
	}
}

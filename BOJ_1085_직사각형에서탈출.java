package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1085_직사각형에서탈출 {

	static int X, Y, W, H;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int ans = Math.min(X, Math.min(Y, Math.min(H-Y,W-X)));
		System.out.println(ans);
	}

}

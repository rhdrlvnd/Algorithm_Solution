package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447_별찍기10_200803 {

	static int[][] map;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		 map = new int[N][N];
		 int len = 1;
		 while(N/3 != 1) {
			 N /= 3;
			 len++;
		 }
		//drawMap(N, len);
	}
	
//	public static void drawMap(int N, int len) {
//		if(N/3 != 1) {
//			drawMap(N/3);
//		}else {
//			map[]
//		}
//		
//	}

}

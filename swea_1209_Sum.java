package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1209_Sum {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[100][100];
		
		for(int tc = 0; tc < 10; tc++) {
			int[] sum_x = new int[100];
			int[] sum_y = new int[100];
			int sum_c = 0;
			int T = Integer.parseInt(br.readLine());
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					sum_x[i] += map[i][j];
					sum_y[j] += map[i][j];
					if(i == j)
						sum_c += map[i][j];
				}
			}
			
			int MAX = sum_c;
			for(int i = 0; i < 100; i++) {
				if(sum_x[i] > MAX)
					MAX = sum_x[i];
				if(sum_y[i] > MAX)
					MAX = sum_y[i];
			}
			System.out.println(MAX);
		}

	}

}

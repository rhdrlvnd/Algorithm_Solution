package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	static ArrayList<Integer> list;
	static boolean isExist;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(list);
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			isExist = false;
			check(Integer.parseInt(st.nextToken()), 0, list.size());
			if(isExist)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
	
	public static void check(int n, int start, int end) {
		if(start - end > 0 || (start+end)/2 >= list.size()) return;
		if(list.get((start+end)/2) < n) {
			check(n, ((start+end)/2)+1, end);
		}else if(list.get((start+end)/2) > n) {
			check(n, start, ((start+end)/2)-1);
		}else {
			isExist = true;
		}
		
	}

}

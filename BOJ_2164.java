package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BOJ_2164 {

	static LinkedList<Integer> q;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		q = new LinkedList<Integer>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while(q.size() != 1) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
	}

}

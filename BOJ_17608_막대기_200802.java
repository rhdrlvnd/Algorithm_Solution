package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17608_막대기_200802 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < N; i++) {
			int height = Integer.parseInt(br.readLine());
			if(st.isEmpty() == true || st.peek() > height) {
				st.push(height);
			}else if(st.peek() < height) {
				while(true) {
					st.pop();
					if(st.isEmpty()||st.peek() > height)
						st.push(height);
						break;
				}
			}
		}
		System.out.println(st.size());
	}
}

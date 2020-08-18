package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SWEA_1233_사칙연산유효성검사{

	static int[][] edge;
	static char[] nodes;
	static int N;
	static Stack <Integer> stack;
	static int flag;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; t++) {
			
			N = Integer.parseInt(br.readLine());
			nodes = new char[N+1]; // node 를 배열로
			edge = new int[N+1][2]; //edge[A][2개] <-- A node 의 자식 2개 완전 이진 트리 // 완전 2진 트리가 아닌 경우는 [N+1][N+1]
			stack = new Stack<>();
			flag = 1;
			
			for(int i = 1; i <= N; i++) {
				StringTokenizer tk = new StringTokenizer(br.readLine());
				int nd = Integer.parseInt(tk.nextToken());
				nodes[i] = tk.nextToken().charAt(0);
				//자식 2개 node 를 [0] 와 [1] 에 저장
				for(int j = 0; j < 2; j++) {
					if(tk.hasMoreTokens()) {
						int cnd = Integer.parseInt(tk.nextToken());
						edge[nd][j] = cnd;
					}
				}
			}
			dfs(1);
			System.out.println("#" + t + " " + flag);
		}
	}
	
	public static void op(char c) {
		
		if( c == '+' || c == '-' || c == '*' || c == '/') {
			if(stack.size() < 2) {
				flag = 0;
				return;
			}
			
			int a = stack.pop();
			int b = stack.pop();
			
			switch(c) {
				case '+' : stack.push(b+a); break;
				case '-' : stack.push(b-a); break;
				case '*' : stack.push(b*a); break;
				case '/' : if(a == 0) a = 1; stack.push(b/a); break;
			}
		}
		else {
			stack.push( c - '0');
		}
	}
	
	public static void dfs(int x) {
		
		if( flag == 0 ) return; // 다른 dfs()에 의해 flag 가 판단되면 종료!
		
		// 자식 2개 탐색
		for(int i = 0; i < 2; i++) {
			if(edge[x][i] == 1) {
				dfs(i);
			}
		}
		op(nodes[x]);
	}
}
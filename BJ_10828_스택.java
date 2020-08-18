package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_10828_스택 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			case "push":
				//System.out.println(Integer.parseInt(st.nextToken()));
				int num = Integer.parseInt(st.nextToken());
				stack.push(num);
				break;
			
			case "top":
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.peek());
				break;
				
			case "size":
				System.out.println(stack.size());
				break;
			
			case "empty":
				if(!stack.isEmpty())
					System.out.println(0);
				else
					System.out.println(1);
				break;
				
			case "pop":
				if(stack.isEmpty())
					System.out.println(-1);
				else
					System.out.println(stack.pop());
				break;
			default:
				break;
			}
		}
	}

}

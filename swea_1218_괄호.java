package com.ssafy;

import java.util.Scanner;
import java.util.Stack;

public class swea_1218_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			char[] array = sc.next().toCharArray();
			boolean check = false;
			OUTER : for(int i = 0; i < N; i++) {
				switch (array[i]) {
				case '(':
					st.push(array[i]);
					break;
					
				case '[':
					st.push(array[i]);
					break;
					
				case '{':
					st.push(array[i]);
					break;
					
				case '<':
					st.push(array[i]);
					break;
					
				case ')':
					if((char)st.peek() != '(') {
						System.out.println(0);
						check = true;
						break OUTER;
					}
					st.pop();
					break;
					
				case ']':
					if((char)st.peek() != '[') {
						System.out.println(0);
						check = true;
						break OUTER;
					}
					st.pop();
					break;
					
				case '}':
					if((char)st.peek() != '{') {
						System.out.println(0);
						check = true;
						break OUTER;
					}
					st.pop();
					break;
					
				case '>':
					if((char)st.peek() != '<') {
						System.out.println(0);
						check = true;
						break OUTER;
					}
					st.pop();
					break;
				default:
					break;
				}
			}
			if(!check)
				System.out.println(1);
			
		}
	}
}

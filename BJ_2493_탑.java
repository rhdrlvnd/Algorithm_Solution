package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stoken = new StringTokenizer(br.readLine());

//		Scanner sc = new Scanner(System.in);
		Stack<Long> height = new Stack<>();
		Stack<Integer> index = new Stack<>();
//		int N = sc.nextInt();
		int[] result = new int[N];
		long a = Long.parseLong(stoken.nextToken());
		height.push(a);
		index.push(1);
		System.out.print("0 ");
		for (int i = 1; i < N; i++) {
			a = Long.parseLong(stoken.nextToken());
			while (true) {
				if(!height.isEmpty()) {
					if (height.peek() < a) {
						height.pop();
						index.pop();
					}else {
						System.out.print(index.peek() + " ");
						height.push(a);
						index.push(i+1);
						break;
					}
				}else {
					System.out.print(0 + " ");
					height.push(a);
					index.push(i+1);
					break;
				}
			}
			height.push(a);
			index.push(i+1);
		}
	}
}

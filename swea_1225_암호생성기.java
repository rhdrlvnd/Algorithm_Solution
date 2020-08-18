package com.ssafy;

import java.util.LinkedList;
import java.util.Scanner;

public class swea_1225_암호생성기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		int T = 10;
		
		for(int tc = 0; tc < T; tc++) {
			int num = sc.nextInt();
			for(int i = 0; i < 8; i++) {
				q.offer(sc.nextInt());
			}
			int cnt = 1;
			while(true) {
				int temp = q.poll();
				if(temp - cnt<= 0) {
					q.offer(0);
					break;
				}
				q.offer(temp-cnt);
				cnt++;
				if(cnt == 6)
					cnt = 1;
			}
			System.out.print("#"+num + " ");
			for(int i = 0; i < 8; i++) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}
	}
}

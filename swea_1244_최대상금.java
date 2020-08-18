package com.ssafy;

import java.util.Scanner;

public class swea_1244_최대상금 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0; tc<T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] num = new int[6];
			int MAX = 0;
			int MAX_index = 0;
			
			//�迭�� �� �ֱ�
			int len = 0;
			for(int i = 0; i < 6; i++) {
				num[i] = N%10;
				N /= 10;
				len++;
				if(N == 0) break;
			}
			
			for(int n = 0; n <M; n++) {
				//�ִ밪 ã��
				for(int i = 0; i <len; i++) {
					if(num[i] > MAX) {
						MAX = num[i];
						MAX_index = i;
					}
				}
				
			}
			for(int i = 0; i <len; i++) {
				System.out.print(num[len-i-1]);
			}
		}
	}
}

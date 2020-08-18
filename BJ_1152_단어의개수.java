package com.ssafy;

import java.util.Scanner;

public class BJ_1152_단어의개수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] S = sc.nextLine().trim().split(" ");
		if(S.length == 1 && S[0].equals(""))
			System.out.println(0);
		else
			System.out.println(S.length);
		
	}

}

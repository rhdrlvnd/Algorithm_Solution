package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2_210127 {

	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> cardList = new HashMap<Integer,Integer>();
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(cardList.containsKey(card))
				cardList.put(card, cardList.get(card)+1);
			else
				cardList.put(card, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int card = Integer.parseInt(st.nextToken());
			if(cardList.containsKey(card))
				sb.append(cardList.get(card) + " ");
			else
				sb.append(0 + " ");
		}
		System.out.println(sb.toString());
	}

}

package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.lang.String;

public class BOJ_1181_단어정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if(!list.contains(s)) {
				list.add(s);
			}
		}

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() != o2.length())
					return o1.length() - o2.length();
				return o1.compareTo(o2);
			}

		});
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

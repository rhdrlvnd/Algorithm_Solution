package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1863_종교_200804 {

	static int[] parent;
	static int[] cnt;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		cnt = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			parent[i] = i;
			cnt[i] = 1;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a, b);
		}
		
		int ans = 0;
		int[] visit = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			if(find(find(i)) != find(i)) {
				parent[find(i)] = find(find(i));
			}
		}
		for(int i = 1; i < N+1; i++) {
			visit[find(i)]++;
		}
		
		for(int i = 1; i < N+1; i++) {
			if(visit[i] != 0)
				ans++;
		}
		System.out.println(ans);
	}
	
	public static void union(int a, int b) {
		if(find(a) < find(b)) {
			parent[find(b)] = find(a);
			cnt[b] += cnt[a];
		}
		else {
			parent[find(a)] = find(b);
			cnt[a] += cnt[b];
		}
	}
	
	public static int find(int a) {
		if(a == parent[a])
			return a;
		return find(parent[a]);
	}
}
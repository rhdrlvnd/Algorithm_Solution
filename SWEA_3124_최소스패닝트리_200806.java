package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class SWEA_3124_최소스패닝트리_200806{

	static int parent[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			Edge[] edgeList = new Edge[E];
			int[] visit = new int[V+1];
			parent = new int[V+1];
			make(parent);
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				if(x <= y)
					edgeList[i] = new Edge(x, y, weight);
				else
					edgeList[i] = new Edge(y, x, weight);
			}
			
			Arrays.sort(edgeList);
			
			int cnt = 0;
			long ans = 0;
			for(int i = 0; i < E; i++) {
				Edge now = edgeList[i];
				if(visit[now.x] == 0 || visit[now.y] == 0) {
					ans += now.weight;
					cnt++;
					visit[now.x] = 1;
					visit[now.y] = 1;
					union(now.x, now.y);
				}
				if(cnt == V-1)
					break;
			}
			System.out.println("#" + (tc+1) + " " +ans);
		}
	}
	
	public static void make(int[] parent) {
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		return find(parent[x]);
	}
	
	public static void union(int a, int b) {
		if(find(a) != find(b)) {
			if(find(a) < find(b))
				parent[find(b)] = find(a);
			else
				parent[find(a)] = find(b);
		}
	}
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		int weight;
		
		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
}

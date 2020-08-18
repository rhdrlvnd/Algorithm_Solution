package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1240_노드사이의거리_200811 {

	static ArrayList<Point>[] tree;
	//static int[][] map;
	static int[][] arr;
	static boolean[] visit;
	static LinkedList<Point> q;
	static int[] ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// map = new int[N+1][N+1];
		tree = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<Point>();
		}
		for(int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			tree[from].add(new Point(from, to, weight));
			tree[to].add(new Point(to, from, weight));
		}
		
		for(int i = 0; i < M; i++) {
			ans = new int[N+1];
			visit = new boolean[N+1];
			q = new LinkedList<Point>();
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			for(int j = 0; j < tree[from].size(); j++) {
				q.offer(tree[from].get(j));
			}
			visit[from] = true;
			bfs();
			System.out.println(ans[to]);
		}
	}
	
	public static void bfs() {
		while(!q.isEmpty()) {
			Point now = q.poll();
			ans[now.to] = ans[now.from]+now.weight;
			if(visit[now.to] == false) {
				for(int j = 0; j < tree[now.to].size(); j++) {
					if(visit[tree[now.to].get(j).to] == false) {
						visit[now.to] = true;
						q.offer(tree[now.to].get(j));
					}
				}
			}
		}
	}

	static class Point {
		int from;
		int to;
		int weight;
		
		public Point(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}

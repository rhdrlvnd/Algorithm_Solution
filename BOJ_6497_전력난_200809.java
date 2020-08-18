package com.ssafy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_6497_전력난_200809 {

	static int N, M;
	static LinkedList<Edge> edgeList;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			if (M == 0 && N == 0)
				break;

			edgeList = new LinkedList<Edge>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList.offer(new Edge(from, to, weight));
			}

			Collections.sort(edgeList, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					return o1.weight - o2.weight;
				}

			});

			parent = new int[M];
			makeSet();
			int ans = 0;
			for (int i = 0; i < N; i++) {
				Edge now = edgeList.poll();
				if (find(now.from) != find(now.to)) {
					unionSet(now.from, now.to);
				} else
					ans += now.weight;
			}
			bw.write(String.valueOf(ans));	
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}

	public static void makeSet() {
		for (int i = 0; i < M; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	public static void unionSet(int from, int to) {
		if (find(from) != find(to)) {
			if (from < to) {
				parent[find(to)] = find(from);
			} else {
				parent[find(from)] = find(to);
			}
		}
	}

	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}

}

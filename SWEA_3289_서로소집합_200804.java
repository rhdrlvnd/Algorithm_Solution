package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합_200804 {
	static int[] root;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		root = new int[N+1];
		parent = new int[N+1];
		for (int i = 0; i < N; i++)
		    parent[i] = i;
		
		
	}
	
	int find(int x) {
	    if (root[x] == x) {
	        return x;
	    } else {
	        return find(root[x]);
	    }
	}

	void union(int x, int y){
	    x = find(x);
	    y = find(y);

	    root[y] = x;
	}
}

class Set{
	int no;
	Set link;
	public Set(int no, Set link) {
		this.no = no;
		this.link = link;
	}
}

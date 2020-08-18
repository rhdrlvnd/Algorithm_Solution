package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1238_Contact_200804 {
	static int[][] map;
	static Node[] node;
	static int[] visit;
	static int MAX, MAX_index;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 0; tc < 1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map = new int[101][101];
			node = new Node[101];
			visit = new int[101];
			int node_N = Integer.parseInt(st.nextToken());
			int startNode = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			MAX = 0;
			MAX_index = startNode;
			for(int i = 0; i < node_N/2; i++) {
				int no = Integer.parseInt(st.nextToken());
				int link = Integer.parseInt(st.nextToken());
				map[no][link] = 1;
				if(node[no] == null) {
					if(node[link] == null) {
						node[link] = new Node(link);
					}
					node[no] = new Node(no, node[link]);
					node[no].setLastNode(node[link]);
				}else {
					if(node[link] == null) {
						node[link] = new Node(link);
					}
					if(node[no].getLastNode() == null)
						node[no].link = node[link];
					else
						node[no].getLastNode().link = node[link];
					node[no].setLastNode(node[link]);
				}
			}
			visit[startNode] = 1;
			dfs(node[startNode], 1);
			System.out.println(visit[88]);
		}
	}
	
	public static void dfs(Node n, int cnt) {
		for(int i = 1; i <101; i++) {
			if(map[n.no][i] == 1 && visit[i] == 0) {
				visit[i] = cnt+1;
				if(visit[i] > MAX) {
					MAX = visit[i];
					MAX_index = i;
				}
				dfs(node[i], cnt+1);
			}else if(visit[i] == MAX) {
				if(i > MAX_index) {
					MAX_index = i;
				}
			}else if(visit[i]>0){
				if(visit[i] > cnt+1)
					visit[i] = cnt+1;
			}
		}
	}
}

class Node{
	int no;
	Node link;
	Node lastNode;
	
	Node(int no){
		this.no = no;
	}
	
	Node(int no, Node link){
		this.no = no;
		this.link = link;
	}
	
	public Node getLastNode(){
		return lastNode;
	}
	
	public void setLastNode(Node n) {
		this.lastNode = n;
	}
}

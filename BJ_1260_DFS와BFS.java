package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1260_DFS와BFS {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodeCnt = Integer.parseInt(st.nextToken());
		int lineCnt = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] nodeList = new LinkedList[nodeCnt+1];
		for(int i = 0; i < nodeCnt; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}
	}
}

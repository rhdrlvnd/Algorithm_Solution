import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1719_택배_210627 {

	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N+1][N+1];
		int[][] ans = new int[N+1][N+1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			map[from][to] = weight;
			map[to][from] = weight;
		}

		for (int i = 1; i < map.length; i++) {
			check(i, map, ans);
		}
		

		for (int i = 1; i < ans.length; i++) {
			for (int j = 1; j < ans.length; j++) {
				if(i == j)
					System.out.print("- ");
				else
					System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void check(int start, int[][] map, int[][] ans) {
		LinkedList<Integer> q = new LinkedList<Integer>();
		int[] visit = new int[N+1];

		q.offer(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for (int i = 1; i < map[now].length; i++) {
				if(i == start) continue;
				if(map[now][i] != 0 && (visit[i] > visit[now] + map[now][i] || visit[i] == 0 )) {
					if(now == start) {
						ans[start][i] = i;
						visit[i] = map[start][i];
					}
					else {
						ans[start][i] = ans[start][now];
						visit[i] = visit[now] + map[now][i];
					}
					q.offer(i);
				}
			}
		}
	}
}

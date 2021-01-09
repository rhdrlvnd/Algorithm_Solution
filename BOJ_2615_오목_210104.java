package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2615_오목_210104 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] board = new int[19][19];
		
		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != 0)
                     answer = checkWin(board, i, j, board[i][j]);
                if(answer != 0) {
                   System.out.println(answer);
                   System.out.println((i+1) + " " + (j+1));
                   return;
                }
            }
        }
        System.out.println(0);
	}
	
	static int[][] delta = {{0, 1}, {-1, 1}, {1, 0}, {1, 1}};
    static private int checkWin(int[][] board, int x, int y, int color){
        for(int i = 0; i < delta.length; i++){
            int cnt = 0;
            int nx = x;
            int ny = y;
            while(true){
                nx += delta[i][0];
                ny += delta[i][1];
                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[nx].length || board[nx][ny] != color) break;
                cnt++;
                if(cnt > 4) break;
            }
            if(cnt == 4){
                int reverse_x = x - delta[i][0];
                int reverse_y = y - delta[i][1];
                if(reverse_x < 0 || reverse_y < 0 || reverse_x >= board.length || reverse_y >= board[reverse_x].length || board[reverse_x][reverse_y] != color)
                    return color;
            } 
        }
        return 0;
    }

}

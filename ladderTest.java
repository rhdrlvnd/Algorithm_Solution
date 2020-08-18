package com.ssafy;

/////////////////////////////////////////////////////////////////////////////////////////////
//�⺻ �����ڵ�� ���� �����ص� ���� �����ϴ�. ��, ����� ���� ����
//�Ʒ� ǥ�� ����� ���� �ʿ�� �����ϼ���.
//ǥ�� �Է� ����
//int a;
//double b;
//char g;
//String var;
//long AB;
//a = sc.nextInt();                           // int ���� 1�� �Է¹޴� ����
//b = sc.nextDouble();                        // double ���� 1�� �Է¹޴� ����
//g = sc.nextByte();                          // char ���� 1�� �Է¹޴� ����
//var = sc.next();                            // ���ڿ� 1�� �Է¹޴� ����
//AB = sc.nextLong();                         // long ���� 1�� �Է¹޴� ����
/////////////////////////////////////////////////////////////////////////////////////////////
//ǥ�� ��� ����
//int a = 0;                            
//double b = 1.0;               
//char g = 'b';
//String var = "ABCDEFG";
//long AB = 12345678901234567L;
//System.out.println(a);                       // int ���� 1�� ����ϴ� ����
//System.out.println(b); 		       						 // double ���� 1�� ����ϴ� ����
//System.out.println(g);		       						 // char ���� 1�� ����ϴ� ����
//System.out.println(var);		       				   // ���ڿ� 1�� ����ϴ� ����
//System.out.println(AB);		       				     // long ���� 1�� ����ϴ� ����
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
����ϴ� Ŭ�������� Solution �̾�� �ϹǷ�, ������ Solution.java �� ����� ���� �����մϴ�.
�̷��� ��Ȳ������ �����ϰ� java Solution ������� ���α׷��� �����غ� �� �ֽ��ϴ�.
*/
class Solution {
	static int[][] ladder;
	public static void main(String args[]) throws Exception {
		/*
		 * �Ʒ��� �޼ҵ� ȣ���� ������ ǥ�� �Է�(Ű����) ��� input.txt ���Ϸκ��� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�. �������� �ۼ��� �ڵ带
		 * �׽�Ʈ �� ��, ���Ǹ� ���ؼ� input.txt�� �Է��� ������ ��, �� �ڵ带 ���α׷��� ó�� �κп� �߰��ϸ� ���� �Է��� ������ ��
		 * ǥ�� �Է� ��� ���Ϸκ��� �Է��� �޾ƿ� �� �ֽ��ϴ�. ���� �׽�Ʈ�� ������ ������ �Ʒ� �ּ��� ����� �� �޼ҵ带 ����ϼŵ� �����ϴ�.
		 * ��, ä���� ���� �ڵ带 �����Ͻ� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ� ó�� �ϼž� �մϴ�.
		 */
//System.setIn(new FileInputStream("res/input.txt"));

		/*
		 * ǥ���Է� System.in ���κ��� ��ĳ�ʸ� ����� �����͸� �о�ɴϴ�.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		ladder = new int[100][100];
		
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */

		for (int test_case = 0; test_case < T; test_case++) {
			for(int i = 0; i<100; i++) {
				for(int j = 0; j< 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}
/////////////////////////////////////////////////////////////////////////////////////////////
			/*
			 * �� �κп� �������� �˰��� ������ ���ϴ�.
			 */
/////////////////////////////////////////////////////////////////////////////////////////////
			int x = 0, y = 0;
			for(int i = 0; i<100; i++) {
				if(ladder[i][99] == 2) {
					x = i;
					y = 99;
				}
			}
			go_up(x,y);
		}
	}
	
	public static void go_up(int x, int y) {
		System.out.println(x +" " + y);
		if(y == 0) {
			System.out.println(x);
			return;
		}
		if(x==0 && ladder[x+1][y] == 1) {
			go_right(x+1,y);
		}else if(x==99 && ladder[x-1][y] == 1 ) {
			go_left(x-1,y);
		}else {
			go_up(x,y-1);
		}
	}
	
	public static void go_left(int x, int y) {
		System.out.println(x +" " + y);
		if(ladder[x][y-1] == 1)
			go_up(x, y-1);
		else
			go_left(x-1, y);
	}
	
	public static void go_right(int x, int y) {
		System.out.println(x +" " + y);
		if(ladder[x][y-1] == 1)
			go_up(x, y-1);
		else
			go_left(x+1, y);
	}
}
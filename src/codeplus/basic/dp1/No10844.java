package codeplus.basic.dp1;

import java.util.Scanner;

public class No10844 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int arr[][] = new int[101][10];
		
		arr[1] = new int[]{0,1,1,1,1,1,1,1,1,1};
		
		for(int i=2; i<=100; i++) {
			arr[i][0] = arr[i-1][1] % 1000000000;
			for(int j=1; j<9; j++) {
				arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
			}
			arr[i][9] = arr[i-1][8] % 1000000000;
		}
		
		int sum = 0;
		for(int i : arr[N]) {
			sum += i;
			sum %= 1000000000;
		}
		System.out.println(sum);
		sc.close();
	}
}

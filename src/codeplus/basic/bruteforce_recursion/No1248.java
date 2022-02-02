package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1248 {
	
	static int N;
	static int[] arr;
	static char[][] signs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		signs = new char[N][N];
		
		String line = br.readLine();
		int idx = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				signs[i][j] = line.charAt(idx++);
			}
		}
		
		dfs(0);
		br.close();
	}

	private static void dfs(int depth) {
		if(depth == N) {
			for(int i=0; i<N; i++)
				System.out.print(arr[i] + " ");
			System.exit(0);
			return;
		}
		
		for(int i= -10; i<= 10; i++) {
			arr[depth] = i;
			if(check(depth))dfs(depth + 1);
		}
	}

	private static boolean check(int depth) {
		for(int i=0; i<=depth; i++) {
			int sum = 0;
			for(int j=i; j<=depth; j++) {
				sum += arr[j];
				if(signs[i][j] != (sum == 0 ? '0' :  (sum > 0 ? '+' : '-'))) {
					return false;
				}
			}
		}
		return true;
	}
}

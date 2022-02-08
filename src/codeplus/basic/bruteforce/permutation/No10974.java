package codeplus.basic.bruteforce.permutation;

import java.util.Scanner;

public class No10974 {
	
	static int N;
	static StringBuilder sb;
	static boolean visit[];
	static int arr[];
	static String nums;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();
		N = sc.nextInt();
		visit= new boolean[N];
		arr = new int[N];
		
		dfs(0);
		System.out.println(sb);
		sc.close();
	}
	private static void dfs(int depth) {
		if(depth == N) {
			for(int i=0; i<N; i++) {
				sb.append(arr[i] + " ");
			}sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			arr[depth] = i+1;
			dfs(depth + 1);
			visit[i] = false;
		}
	}
}

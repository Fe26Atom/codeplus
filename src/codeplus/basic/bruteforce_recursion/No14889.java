package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14889 {

	static int mat[][];
	static boolean visit[];
	static int N;
	static long min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		System.out.println(min);
		br.close();
	}

	private static void dfs(int start, int depth) {
		if(depth == N/2) {
			min = Math.min(min , check());
			if(depth % 2 == 0)
				return;
		}
		if(depth == N/2 + 1) {
			min = Math.min(min , check());
			return;
		}
		
		for(int i=start; i<N; i++) {
			visit[i] = true;
			dfs(i+1, depth + 1);
			visit[i] = false;
		}
	}

	private static long check() {
		long s1 = 0;
		long s2 = 0;
		
		for(int i=0; i<N; i++) {
			for(int j= i + 1; j<N; j++) {
				if(visit[i] == visit[j]) {
					if(visit[i]) s1 += mat[i][j] + mat[j][i];
					else s2 += mat[i][j] + mat[j][i] ;
				}
			}
		}
		return Math.abs(s1 - s2);
	}
}

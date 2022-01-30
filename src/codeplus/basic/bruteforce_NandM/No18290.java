package codeplus.basic.bruteforce_NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No18290 {

	static int N, M, K, max = Integer.MIN_VALUE;
	static int[] dirx = new int[] { -1, 0, 1, 0 };
	static int[] diry = new int[] { 0, -1, 0, 1 };
	static int[] arr;
	static int[][] mat;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[K];
		mat = new int[N + 2][M + 2];
		visit = new int[N + 2][M + 2];
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < M  + 1; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);

		System.out.println(max);
		br.close();
	}

	private static void dfs(int depth) {

		if (depth == K) {
			int sum = 0;
			for (int i : arr) {
				sum += i;
			}
			max = max < sum ? sum : max;
			return;
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < M + 1; j++) {
				if (visit[i][j] > 0)
					continue;
				
				if(check(i, j))
					continue;
				
				visit[i][j]++;
				arr[depth] = mat[i][j];
				dfs(depth + 1);
				visit[i][j]--;
				
			}
		}
	}

	private static boolean check(int i, int j) {
		for(int d=0; d<4; d++) {
			int nx = i + dirx[d];
			int ny = j + diry[d];
			
			if(visit[nx][ny] > 0) {
				return true;
			}
		}
		return false;
	}
}
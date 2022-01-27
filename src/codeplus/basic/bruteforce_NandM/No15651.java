package codeplus.basic.bruteforce_NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15651 {

	static int N;
	static int M;

	static StringBuilder sb = new StringBuilder();
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		dfs(0);

		System.out.println(sb);
		br.close();
	}

	private static void dfs(int depth) {

		if(depth == M) {
			for(int val : arr) {
				sb.append(val).append(" ");
			}sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			arr[depth] = i+1;
			dfs(depth + 1);
		}
	}

}

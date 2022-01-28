package codeplus.basic.bruteforce_NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No15655 {

	static int N;
	static int M;

	static int arr[];
	static int nums[];
	static boolean visit[];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		nums = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		dfs(0,0);
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int start, int depth) {
		if (depth == M) {
			for (int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = start; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = nums[i];
				dfs(i + 1, depth + 1);
				visit[i] = false;
			}
		}
	}
}

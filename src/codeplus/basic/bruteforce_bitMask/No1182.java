package codeplus.basic.bruteforce_bitMask;
// 비트마스크로 안 품

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1182 {
	static int arr[];
	static int N,S, count=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,0);
		
		System.out.println(count);
		
		br.close();
	}

	private static void dfs(int depth, int start, int sum) {
		if(depth == N) {
			return;
		}
		for(int i=start; i<N; i++) {
			if(sum + arr[i] == S) count++;
			dfs(depth+1, i+1, sum + arr[i]);
		}
	}
}

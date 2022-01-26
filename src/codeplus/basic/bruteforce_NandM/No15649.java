package codeplus.basic.bruteforce_NandM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15649 {
	
	static int N;
	static int M;
	
	static boolean visit[] = new boolean[9];
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		
		
		for(int i=1; i<=N; i++) {
			visit[i] = true;
			arr[0] = i;
			check(1);
			visit[i] = false;
		}
		
		br.close();
	}

	private static void check(int depth) {
		if(depth == M) {
			for(int i=0; i<M; i++) {
				System.out.print(arr[i] + " ");
			}System.out.println();
			return;
		}
		
		for(int i=1; i <= N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				arr[depth] = i;
				check(depth + 1);
				visit[i] = false;
			}
		}
	}
}

package codeplus.pra.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14225 {
	static int N, arr[]; 
	static boolean nums[] = new boolean[2000001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0);
		
		for(int i=1; i<2000001; i++) {
			if(!nums[i]) {
				System.out.println(i);
				break;
			}
		}
		
		br.close();
	}
	private static void dfs(int start, int sum) {
		for(int i=start; i<N; i++) {
			nums[sum + arr[i]] = true;
			dfs(i + 1, sum +arr[i]);
		}
	}
}
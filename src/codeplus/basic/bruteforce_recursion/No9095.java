package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {
	static int count = 0;
	static int arr[] = {1,2,3};
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T =  Integer.parseInt(br.readLine());
		
		while(T-->0) {
			count = 0;
			n = Integer.parseInt(br.readLine());
			
			dfs(0);
			sb.append(count + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int sum) {
		if(sum > n) {
			return;
		}
		if(sum == n) {
			count++;
			return;
		}
		
		for(int i=0; i<3; i++) {
			dfs(sum + arr[i]);
		}
	}
}

package codeplus.basic.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11053 {	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int arr[] = new int[N+1];
		int dp[] = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int mc = 0;
		
		for(int i=1; i<=N; i++) {
			int j = i-1;
			while(arr[i] <= arr[j]) j--;
			dp[i] = dp[j] + 1;
		}
		
		for(int i : dp) {
			System.out.print(i + " ");
		}System.out.println();
		
		System.out.println(mc);
		br.close();
	}
}

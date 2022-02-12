package codeplus.basic.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16194 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for(int i=1; i<N; i++) {
			for(int j = 0; j<i; j++) {
				dp[i] = Math.min(dp[i],dp[i-j-1] + arr[j]);
			}
		}
		System.out.println(dp[N-1]);
		br.close();
	}
}

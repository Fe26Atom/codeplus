package codeplus.basic.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No15990 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long dp[][] = new long[100001][4];
		
		dp[1] = new long[] {1, 1, 0, 0};
		dp[2] = new long[] {1, 0, 1, 0};
		dp[3] = new long[] {3, 1, 1, 1};
				
		int n = Integer.parseInt(br.readLine());
				
		for(int i=4; i<100001; i++) {
			dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1000000009;
			dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1000000009;
			dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1000000009;
			dp[i][0] = (dp[i][1] + dp[i][2] + dp[i][3]) % 1000000009;
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(dp[Integer.parseInt(br.readLine())][0]);
		}
		
		br.close();
	}
}

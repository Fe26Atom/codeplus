package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 공약수들의 합을 dp로 풀기
public class No17425 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());

		long fx[] = new long[1000001];
		long dp[] = new long[1000001];
		
		Arrays.fill(fx, 1);
		
		for(int i=2; i<1000001; i++) {
			for(int j=1; i*j <1000001; j++) {
				fx[i * j] += i;
			}
		}
		
		for(int i=1; i<1000001; i++) {
			dp[i] = dp[i - 1] + fx[i];
		}
		
		while(T-- > 0) {
			int num = Integer.parseInt(br.readLine());
			sb.append(dp[num]).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}

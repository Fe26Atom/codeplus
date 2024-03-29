package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No17427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long ans = 0;
		
		for(int i=1; i<=N; i++) {
			ans += N/i * i;
		}
		System.out.println(ans);
		br.close();
	}
}

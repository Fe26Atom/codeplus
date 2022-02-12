package codeplus.basic.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9095 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int ans[] = new int[11];
		
		ans[1] = 1;
		ans[2] = 2;
		ans[3] = 4; // 111, 12, 21, 3
		
		for(int i=4; i<11; i++) {
			ans[i] = ans[i-3] + ans[i-2] + ans[i-1];
		}
		
		for(int tc = 0; tc<T; tc++) {
			System.out.println(ans[Integer.parseInt(br.readLine())]);
		}
		br.close();
	}
}

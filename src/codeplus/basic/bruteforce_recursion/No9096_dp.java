package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No9096_dp {
	static int count[] = new int[11];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T =  Integer.parseInt(br.readLine());
		
		checkDP();
		
		while(T-->0) {
			int n = Integer.parseInt(br.readLine());
			sb.append(count[n] + "\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void checkDP() {
		count[1] = 1;
		count[2] = 2;
		count[3] = 4;
		for(int i=4; i<11; i++) {
			count[i] = count[i - 3] + count[i - 2] + count[i - 1];
		}
	}

}

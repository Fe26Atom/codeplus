package codeplus.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No2309 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int height[] = new int[9];
		boolean check[] = new boolean[9];
		
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		
		Arrays.sort(height);
		
		sum -= 100;
		
		for(int i=0; i<8; i++) {
			for(int j = i + 1; j<9; j++) {
				if(height[i] + height[j] == sum) {
					check[i]= true;
					check[j]= true;
					break;
				}
			}
			if(check[i]) break;
		}

		for(int i=0; i<9; i++) {
			if(!check[i]) {
				sb.append(height[i]).append("\n");
			}
		}
		System.out.println(sb);
		br.close();
		
	}
}

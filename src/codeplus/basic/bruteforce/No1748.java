package codeplus.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int count = 0;
		int j = 10;
		int ch = 1;
		for(int i=1; i<=N; i++) {
			if(i/j !=0) {
				ch++;
				j *= 10;
			}
			count += ch;
		}
		
		System.out.println(count);
		
		br.close();
	}
}

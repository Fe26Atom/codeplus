package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1037 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int div = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<div; i++) {
			int num = Integer.parseInt(st.nextToken());
			min = min < num ? min : num;
			max = max > num ? max : num;
		}
		System.out.println((long)min * max);
		br.close();
	}
}

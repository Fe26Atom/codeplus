package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1929 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		int size = 1000;
		
		boolean[] arr =new boolean[size + 1];
		arr[0] = arr[1] = true;
		
		for(int i=2; i<=size; i++) {
			if(!arr[i]) {
				for(int j=2 * i; j <=size; j += i) {
					arr[j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(N-->0) {
			int number = Integer.parseInt(st.nextToken());
			
			if(!arr[number]) count++;
		}
		System.out.println(count);
		
	}
}	

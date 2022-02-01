package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14501 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int [N + 1];
		
		for(int i=0; i< N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			if(i + T > N)
				continue;
			
			if(arr[i + T] < arr[i] + P) {
				arr[i + T] = arr[i] + P;
				
				for(int j=i + T; j<=N; j++) {
					if(arr[i+T] > arr[j]){
						arr[j] = arr[i + T];
					}
				}
			}
		}
		
		System.out.println(arr[N]);
		
		br.close();
	}
}
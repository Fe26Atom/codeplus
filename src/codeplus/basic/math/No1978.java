package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1978 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int size = N;
		
		boolean[] arr =new boolean[size + 1];
		arr[0] = arr[1] = true;
		
		for(int i=2; i<=size; i++) {
			if(!arr[i]) {
				for(int j=2 * i; j <=size; j += i) {
					arr[j] = true;
				}
			}
		}
		
		for(int idx=M; idx<=N; idx++) {
			if(!arr[idx])
				sb.append(idx).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}	

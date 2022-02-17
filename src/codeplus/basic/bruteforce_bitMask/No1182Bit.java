package codeplus.basic.bruteforce_bitMask;
// 비트마스크로 안 품

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1182Bit {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		int count = 0;
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < (1 << N); i++) {
			int sum = 0;
			for(int k=0; k<N; k++) {
				if((i & (1 << k) ) > 0) {
					sum += arr[k];
				}
			}
			if(sum == S) count++;
		}
		
		System.out.println(count);
		br.close();
	}
}

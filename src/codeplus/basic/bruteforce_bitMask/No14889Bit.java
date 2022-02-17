package codeplus.basic.bruteforce_bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14889Bit {
	
	static int N, min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		int mat[][] = new int[N][N];
		int visit = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<(1 << N); i++) {
			int cnt = 0;
			for(int j = 0; j<N; j++) {
				if((i & (1 << j)) == 0)
					cnt++;
			}

			if(cnt != N/2) {
				continue;
			}
			
//			System.out.println(Integer.toBinaryString(i));
			int start = 0;
			int link = 0;
			
			for(int s=0; s<N; s++) {
				for(int l=0; l<N; l++) {
					if(s==l) continue;

					int n1 = (i & (1<<s)) == 0 ? 0 : 1;
					int n2 = (i & (1<<l)) == 0 ? 0 : 1;
					
					if(n1 == n2) {
						if(n1==0)
							start += mat[s][l];
						else
							link += mat[s][l];
					}
				}
			}
//			System.out.println(start + " " + link);
			min = Math.min(min, Math.abs(start - link));
		}
		System.out.println(min);
		br.close();
	}
}

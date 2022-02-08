package codeplus.pra.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No16197 {
	static int N, M;
	static char mat[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		mat = new char[N][M];
		
		for(int i=0; i<N; i++) {
			mat[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<N; i++) {
			
		}
	}
}

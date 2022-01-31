package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14501 {
	
	static int[][] con;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int arr[] = new int[21];
		con = new int[N][2];
		int max = 0;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());

			con[i][0] = Integer.parseInt(st.nextToken());
			con[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			int end = i + con[i][0];

			arr[end] = Math.max(max, arr[i] + con[i][1]);
			max = Math.max(arr[end], max);
		}
		
		for(int i=0; i<N; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println(max);
	}
	
	
	
}
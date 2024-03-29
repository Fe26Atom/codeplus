package codeplus.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10972_2 {

	static int arr[];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if(check()) {
			for(int i : arr) {
				sb.append(i + " ");
			}sb.append("\n");
		}
		else
			sb.append(-1 + "\n");
		System.out.println(sb);
		br.close();
		
	}

	private static boolean check() {
		int i = N-1;
		while(i >0 && arr[i-1] > arr[i]) i--;
		if(i==0) return false;
		
		int j= N-1;
		while(arr[j] <= arr[i-1]) j--;
		
		swap(i-1, j);
		
		j= N-1;
		
		while(i < j) {
			swap(i, j);
			i++;
			i--;
		}
		return true;
	}

	private static void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
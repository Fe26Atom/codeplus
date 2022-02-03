package codeplus.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_10973 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		if(func(arr)) {
			for(int i : arr) {
				System.out.print(i + " ");
			}System.out.println();
		}
			
		
		br.close();
	}

	private static boolean func(int[] arr) {
		int i = arr.length - 1;
		
		while(i>0 && arr[i] < arr[i-1]) i--;
		if(i == 0) return false;
		
		int j = arr.length - 1;
		
		while(arr[j] <= arr[i-1]) j--;
		
		swap(arr, i-1, j);
		j = arr.length - 1;
		while(i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

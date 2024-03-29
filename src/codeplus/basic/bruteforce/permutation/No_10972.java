package codeplus.basic.bruteforce.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No_10972 {
	
	static int arr[];
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		if(check(arr)) {
			for(int i : arr) {
				System.out.print(i + " ");
			}System.out.println();
		}
		br.close();
	}

	private static boolean check(int[] arr) {
		int i = arr.length - 1;
		while(i > 0 && arr[i-1] > arr[i]) i--;
		
		if(i==0) return false;
		
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

	private static void swap(int[] arr2, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

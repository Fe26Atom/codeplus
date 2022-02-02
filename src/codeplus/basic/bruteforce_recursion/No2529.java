package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2529 {

	static int arr[];
	static boolean used[] = new boolean[10];
	static char sign[];
	static int min[];
	static int max[];
	static int k;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		k = Integer.parseInt(br.readLine());
		arr = new int[k + 1];
		sign = new char[k];
		min = new int[k + 1];
		max = new int[k + 1];
		
		for(int i=0; i<k+1; i++) {
			min[i] = 9;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<k; i++) {
			sign[i] = st.nextToken().charAt(0);
		}
		
		dfs(0);
		
		for(int i=0; i<k+1; i++) {
			sb.append(max[i]);
		}sb.append("\n");
		
		for(int i=0; i<k+1; i++) {
			sb.append(min[i]);
		}sb.append("\n");

		System.out.println(sb);
		
		br.close();
	}

	private static void dfs(int depth) {
		if(depth == k + 1) {
			check();
			return;
		}
		
		for(int i=0; i<10; i++) {
			if(!used[i]) {
				used[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				used[i] = false;
			}
		}
	}

	private static void check() {
		for(int i=0; i<k; i++) {
			if(sign[i] == '<') {
				if(arr[i] > arr[i + 1])
					return;
			}
			else if(sign[i] == '>') {
				if(arr[i] < arr[i + 1])
					return;
			}
		}
		
		for(int i=0; i< k + 1; i++) {
			if(min[i] > arr[i]) {
				small();
				break;
			}
			else if(min[i] == arr[i]) {}
				
			else
				break;
		}
		
		for(int i=0; i<k + 1; i++) {
			if(max[i] < arr[i]) {
				big();
				break;
			}
			else if(max[i] == arr[i]) {}
				
			else
				break;
		}
		
	}

	private static void small() {
		for(int i=0; i<k+1; i++) {
			min[i] = arr[i];
		}
	}

	private static void big() {
		for(int i=0; i<k+1; i++) {
			max[i] = arr[i];
		}
	}

}

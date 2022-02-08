package codeplus.pra.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15658 {
	static int [] signs = new int[4];
	static int [] nums;
	static int N, MAX = Integer.MIN_VALUE, MIN = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<4; i++) {
			signs[i] = Integer.parseInt(st.nextToken());
		}
		
		check(1, nums[0]);
		System.out.println(MAX);
		System.out.println(MIN);
		br.close();
	}

	private static void check(int depth, int num) {
		if(depth == N) {
			MAX = MAX < num ? num : MAX;
			MIN = MIN > num ? num : MIN;
			return;
		}
		
		for(int i=0; i<4; i++) {
			if(signs[i] == 0)
				continue;
			
			int result = num;
			signs[i] = signs[i] - 1;

			switch(i) {
			case 0:
				result += nums[depth];
				break;
			case 1:
				result -= nums[depth];
				break;
			case 2:
				result *= nums[depth];
				break;
			case 3:
				if(result <0) {
					result *= -1;
					result /= nums[depth];
					result *= -1;
				}
				else {
					result /= nums[depth];
				}
				break;
			}
			
			check(depth+1, result);
			signs[i] = signs[i] + 1;
		}
	}
}

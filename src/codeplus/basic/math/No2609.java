package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2609 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 숫자 입력
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		// 크기를 나눔
		int max = f < s ? s : f;
		int min = f < s ? f : s;
		
		// 차끼리 나눠질때 까지
		while(max % min != 0) {
			
			int temp = max - min;
			if(temp > min) max = temp;
			else {
				max = min;
				min = temp;
			}
		}
		
		// min은 최대 공약수
		// 최대 공배수는 둘을 곱한거에서 최대공약수를 나눈 것
		System.out.println(min);
		System.out.println(f * s / min);
		
		br.close();
	}
}

package codeplus.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1476 {
	static int E, S, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		E = Integer.parseInt(st.nextToken()) - 1;
		S = Integer.parseInt(st.nextToken()) - 1;
		M = Integer.parseInt(st.nextToken()) - 1;
		
		int i = 0;
		while(true) {
			int year = 28 * i + S;
			if(year % 15 == E && year % 19 == M) {
				System.out.println(year + 1);
				break;
			}
			i++;
		}
	}
}

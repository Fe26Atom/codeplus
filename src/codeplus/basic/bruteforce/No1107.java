package codeplus.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1107 {
	static boolean button[] = new boolean[10];
	static int min = Integer.MAX_VALUE;

	static int check(int num) {
		if (num == 0) {
			if (button[0])
				return 0;
			else
				return 1;
		}

		int check = 0;
		int number = num;

		while (number > 0) {
			if (button[number % 10])
				return 0;

			number /= 10;
			check++;
		}
		return check;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		if (M != 0)
			st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			button[Integer.parseInt(st.nextToken())] = true;
		}

//		System.out.println(check(N));

		int min = Math.abs(N - 100);

		for (int i = 0; i < 1000000; i++) {
			int len = check(i);
			if (len > 0) {
				int ans = Math.abs(N - i) + len;
				min = min < ans ? min : ans;
			}
		}

		System.out.println(min);

		br.close();

	}
}

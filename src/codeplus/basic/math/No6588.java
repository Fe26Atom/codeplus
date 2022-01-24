package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No6588 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = 1000000;
		boolean era[] = new boolean[size + 1];

		for (int i = 2; i <= size; i++) {
			if (!era[i]) {
				for (int j = i * 2; j <= size; j += i) {
					era[j] = true;
				}
			}
		}

		while (true) {
			boolean check = false;
			int n = Integer.parseInt(br.readLine());
			
			if (n == 0)
				break;
			
			for (int i = 2; i <= n; i++) {
				if (!era[i] && !era[n - i]) {
					sb.append(n + " = " + i + " + " + (n - i)).append("\n");
					check = true;
					break;
				}
			}
			if(!check)
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			
		}
		System.out.println(sb);
		br.close();

	}
}

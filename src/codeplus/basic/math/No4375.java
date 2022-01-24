package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No4375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = "";
		while ((num = br.readLine()) != null) {
			int n = Integer.parseInt(num);
			long check = 1;
			int length = 1;
			
			while (true) {
				if (check % n == 0)
					break;
				check = (check * 10 + 1) % n;
				length++;
			}
			System.out.println(length);
		}
		br.close();
	}
}

package codeplus.basic.dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int arr[] = new int[N + 1];

		arr[0] = 0;
		arr[1] = 1;
		if(N > 1)
			arr[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			arr[i] = arr[i] % 10007;
		}
		System.out.println(arr[N]);
		br.close();
	}
}

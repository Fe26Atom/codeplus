package codeplus.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No3085 {

	static int N;
	static char[][] mat;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int dirx[] = { 0, 1 };
		int diry[] = { 1, 0 };

		mat = new char[N][N];

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			mat[i] = line.toCharArray();
		}

		int max = 0;

		for (int i = 0; i < N; i++) {
			int count = countCandy(i, i);

			max = count < max ? max : count;
		}

		for (int cx = 0; cx < N; cx++) {
			for (int cy = 0; cy < N; cy++) {
				for (int i = 0; i < 2; i++) {
					int nx = cx + dirx[i];
					int ny = cy + diry[i];

					if (nx < N && ny < N) {
						
						if(mat[nx][ny] == mat[cx][cy])
							continue;
						
						char temp = mat[cx][cy];
						mat[cx][cy] = mat[nx][ny];
						mat[nx][ny] = temp;
						
						int count = countCandy(cx, cy);
						max = count < max ? max : count;
						count = countCandy(nx, ny);
						max = count < max ? max : count;
						
						
						temp = mat[cx][cy];
						mat[cx][cy] = mat[nx][ny];
						mat[nx][ny] = temp;
					}
				}

			}
		}
		System.out.println(max);
	}

	private static int countCandy(int i, int j) {
		int count = 1;
		int max = 0;

		for (int x = 1; x < N; x++) {
			if (mat[x - 1][j] == mat[x][j])
				count++;
			else
				count = 1;
			max = count < max ? max : count;
		}
		
		count = 1;
		
		for (int y = 1; y < N; y++) {
			if (mat[i][y - 1] == mat[i][y])
				count++;
			else
				count = 1;
			max = count < max ? max : count;
		}
		return max;
	}
}

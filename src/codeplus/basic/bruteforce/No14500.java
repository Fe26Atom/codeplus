package codeplus.basic.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14500 {
	static int mat[][];
	static boolean visit[][];
	static int max = Integer.MIN_VALUE;
	
	static int dirx[] = new int[] {-1, 0, 1, 0};
	static int diry[] = new int[] {0, -1, 0, 1};
	
	static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		mat = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				mat[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visit[i][j] = true;
//				System.out.println(0 + " " + i + " " + j + " " + mat[i][j]);
				dfs(i, j, 1, mat[i][j]);
				visit[i][j] = false;
				check_ex(i, j);
			}
		}
		
		System.out.println(max);
		
	}
	
	private static void check_ex(int i, int j) {
		int sum_value = 0;
		// 1. ぬ
		if(j+2 <M && i+1 <N) {
			sum_value = mat[i][j] + mat[i][j+1] + mat[i+1][j+1] + mat[i][j+2];
			max = sum_value < max ? max : sum_value;
		}
		
		// 2. で
		if(j+2 <M && 0 <= i-1) {
			sum_value = mat[i][j] + mat[i][j+1] + mat[i-1][j+1] + mat[i][j+2];
			max = sum_value < max ? max : sum_value;
		}
		
		// 3. た
		if(j + 1 <M && i + 2 <N) {
			sum_value = mat[i][j] + mat[i + 1][j] + mat[i + 1][j + 1] + mat[i+2][j];
			max = sum_value < max ? max : sum_value;
		}

		// 4. っ
		if(0 <= j - 1 && i + 2 <N) {
			sum_value = mat[i][j] + mat[i + 1][j] + mat[i+1][j - 1] + mat[i + 2][j];
			max = sum_value < max ? max : sum_value;
		}

		
		
	}

	static void dfs(int cx, int cy, int depth, int count) {
		if(depth == 4) {
			
			//max = max < count ? count : max;
			if(max < count) {
//				System.out.println(depth + " " + cx + " " + cy + " " + count);
				max = count;
			}
			return;
		}
		
		for(int i=0; i<4; i++) {
			int nx = cx + dirx[i];
			int ny = cy + diry[i];
			
			if(0<=nx && 0<=ny && nx < N && ny < M) {
				if(!visit[nx][ny]) {
					visit[nx][ny] = true;
//					System.out.println(depth + " " + cx + " " + cy + " " + count);
					dfs(nx, ny, depth+1, count + mat[nx][ny]);
					visit[nx][ny] = false;
				}
			}
		}
	}
}

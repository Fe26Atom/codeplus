package codeplus.basic.bruteforce_bitMask;
//비트마스크로 안 품
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14889 {
	
	static int N, min = Integer.MAX_VALUE;
	static boolean visit[];
	static int mat[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		mat = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				mat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(min);
		br.close();
	}

	private static void dfs(int depth, int start) {
		if(depth == N/2) {
			check();
			return;
		}
		
		for(int i = start; i<N; i++) {
			visit[i]= true;
			dfs(depth + 1, i+1);
			visit[i] = false;
		}
	}

	private static void check() {
		int start = 0;
		int link = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(visit[i] == visit[j]) {
					if(visit[i]) 
						start += mat[i][j];
					else
						link += mat[i][j];
				}
			}
		}
		min = Math.min(min, Math.abs(start - link));
	}
}

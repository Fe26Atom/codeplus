package codeplus.basic.bruteforce_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1759 {
	static int L,C;
	static char[] arr;
	static int visit[] = new int[26];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		arr = new char[L];
		
		st= new StringTokenizer(br.readLine());
		
		for(int i=0; i<C; i++) {
			visit[st.nextToken().charAt(0) - 'a']++;
		}
		
		dfs(0,0);
		System.out.println(sb);
		br.close();
	}
	private static void dfs(int depth, int start) {
		if(depth == L) {
			if(check(arr))
				return;
			sb.append(String.valueOf(arr)).append("\n");
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(visit[i] == 0 || visit[i] == 2)
				continue;
			visit[i]++;
			arr[depth] = (char) ('a' + i);
			dfs(depth + 1, i + 1);
			visit[i]--;
		}
		
		
	}
	private static boolean check(char[] arr) {
		int count = 0;
		
		if(visit['a' - 'a'] == 2) 
			count++;
		if(visit['e' - 'a'] == 2)
			count++;
		if(visit['i' - 'a'] == 2)
			count++;
		if(visit['o' - 'a'] == 2)
			count++;
		if(visit['u' - 'a'] == 2)
			count++;
		
		if(count >= 1 && L - count >= 2)
			return false;
		return true;
		
	}
}

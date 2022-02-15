package codeplus.basic.bruteforce_bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비트 마스크로 문제 풀이
public class No11723Bit {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		int result = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num = 0;
			if(cmd.equals("add")) {
				num = Integer.parseInt(st.nextToken()) - 1;
				result |= (1 << num);
			}
			else if(cmd.equals("remove")) {
				num = Integer.parseInt(st.nextToken()) - 1;
				result &= ~(result & (1 << num));
			}
			else if(cmd.equals("check")) {
				num = Integer.parseInt(st.nextToken()) - 1;
				if((result & (1 << num )) > 0) 
					sb.append(1 + "\n");
				else
					sb.append(0 + "\n");
			}
			else if(cmd.equals("toggle")) {
				num = Integer.parseInt(st.nextToken()) - 1;
				result ^= (1 << num);
			}
			else if(cmd.equals("all")) {
				result = (1 << 21) -1;
			}
			else if(cmd.equals("empty")) {
				result = 0;
			}
		}
		System.out.println(sb);
		br.close();
	}
}

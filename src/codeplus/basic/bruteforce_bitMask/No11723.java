package codeplus.basic.bruteforce_bitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11723 {
	static boolean arr[] = new boolean [20];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		
		while(M-->0) {
			String line[] = br.readLine().split(" ");
			String cmd = line[0];
			if(cmd.equals("all")) {
				for(int i=0; i<20; i++) {
					arr[i] = true;
				}
				continue;
			}
			
			if(cmd.equals("empty")) {
				arr = new boolean[20];
				continue;
			}
			int num = Integer.parseInt(line[1]);
			
			func(cmd, num - 1);
		}
		System.out.println(sb);
		br.close();
	}

	private static void func(String cmd, int num) {
		if(cmd.equals("add")) {
			arr[num] = true;
		}
		else if(cmd.equals("remove")) {
			arr[num] = false;
		}
		else if(cmd.equals("check")) {
			if(arr[num])
				sb.append(1 + "\n");
			else
				sb.append(0 + "\n");
		}
		else if(cmd.equals("toggle")) {
			arr[num] = !arr[num]; 
		}

	}
}

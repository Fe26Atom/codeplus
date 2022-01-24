package codeplus.basic.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2609 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// ���� �Է�
		int f = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		// ũ�⸦ ����
		int max = f < s ? s : f;
		int min = f < s ? f : s;
		
		// ������ �������� ����
		while(max % min != 0) {
			
			int temp = max - min;
			if(temp > min) max = temp;
			else {
				max = min;
				min = temp;
			}
		}
		
		// min�� �ִ� �����
		// �ִ� ������� ���� ���Ѱſ��� �ִ������� ���� ��
		System.out.println(min);
		System.out.println(f * s / min);
		
		br.close();
	}
}

package codeplus.basic.bruteforce_NandM;

import java.util.Scanner;

public class No18290 {
   
   private static int n;
   private static int m;
   private static int k;
   
   private static int[][] array; //���
   private static int[][] cal; //���� Ȯ��
   
   private static int[] list; //������ �� ���� �迭
   
   private static int max = -100000;
         
   public static void main(String[] args) {
      
      Scanner sc = new Scanner(System.in);
      
      n = sc.nextInt();
      m = sc.nextInt();
      k = sc.nextInt();
      
      list = new int[k];
      
      cal = new int[n][m];
      array = new int[n][m];
      for (int i=0; i<n; i++) {
         for (int j=0; j<m; j++) {
            array[i][j] = sc.nextInt();
         }
      }
      
      cycle(0);
      
      System.out.println(max);
      
   }

   private static void cycle(int start) {
      
      if (start == k) { //���ۼ��ڰ� K���϶� �ִ밪 �ֱ�
         int temp = 0;
         for (int i : list) {
            temp += i;
         }
         max = Math.max(max, temp);
      } else {
         
         for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
               if (cal[i][j] > 0) {
                  continue;
               }
               go(i, j); //���� �Ǻ�
               list[start] = array[i][j]; //���簪 �ֱ�
               cycle(start+1); //���
               back(i, j); //���󺹱�
            }
         }
         
      }
      
   }

   private static void go(int x, int y) {
      cal[x][y]++; //���簪 +1
      if (y-1 >= 0) {
         //���� �����Ҷ�
         cal[x][y-1]++;
      }
      if (x-1 >= 0) {
         //������ �����Ҷ�
         cal[x-1][y]++;
      }
      if (y+1 < m) {
         //�Ʒ��� �����Ҷ�
         //0,0�϶� ���� -> 0,1
         cal[x][y+1]++;
      }
      if (x+1 < n) {
         //�������� �����Ҷ�
         //0,0�϶� ���� -> 1,0
         cal[x+1][y]++;
      }
   }
   
   private static void back(int x, int y) {
      cal[x][y]--;
      if (y - 1 >= 0) {
         cal[x][y-1]--;
      }
      if (x - 1 >= 0) {
         cal[x-1][y]--;
      }
      if (y + 1 < m) {
         cal[x][y+1]--;
      }
      if (x + 1 < n) {
         cal[x+1][y]--;
      }
   }
}
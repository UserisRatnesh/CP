package Codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class Round_957_Div_3 
{
	
	private static void a() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            long ans = 0;

            for (int i = 0; i <= 5; i++) {
                int newA = a + i;
                for (int j = 0; j <= 5 - i; j++) {
                    int newB = b + j;
                    int newC = c + (5 - i - j);

                    ans = Math.max(newA * newB * newC, ans);
                }
            }
            System.out.println(ans);

        }
        sc.close();
    }
	
	private static void b() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long ans = 0;
            for (int i = 0; i < k - 1; i++) {
                if (arr[i] == 1) {
                    ans += 1;
                } else {
                    ans += 1;
                    ans += 2 * (arr[i] - 1);
                }
            }

            System.out.println(ans);
        }
        sc.close();
    }
	
	private static void c() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            for (int i = n; i > m; i--) {
                System.out.print(i + " ");
            }

            for (int i = 1; i <= m; i++) {
                System.out.print(i + " ");
            }
            System.out.println();

        }
        sc.close();
    }

	
	public static void main(String[] args) 
	{
		

	}

}

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

            long ans = 0;
            for (int i = 0; i < k; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);
            for (int i = 0; i < k - 1; i++) {
                ans += 2 * arr[i] - 1;
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
	
	
	public static void d() {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();

            String s = sc.next();
            char[] arr = s.toCharArray();

            if (isPossible(arr, n, m, k)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            sc.close();
        } 
    }
	
	
	public static boolean isPossible(char[] arr, int n, int m, int k) {
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'C') {
                dp[i] = Integer.MAX_VALUE;
            } else if (arr[i] == 'W') {
                dp[i] = dp[i + 1] == Integer.MAX_VALUE ? dp[i + 1] : dp[i + 1] + 1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= m; j++) {
                    if (i + j <= n) {

                        min = Math.min(dp[i + j], min);

                    }

                }
                dp[i] = min;
            }
        }

        for (int i = 0; i < m; i++) {
            if (dp[i] <= k) {
                return true;
            }
        }
        return false;
    }

	
	public static void main(String[] args) 
	{
		

	}

}

package Codeforces;

import java.util.Scanner;

public class Round951_Div_2 {

  private static void a() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      int ans = Integer.MAX_VALUE;
      int l = 0;
      int r = 1;
      while (r < n) {
        int max = Math.max(arr[l], arr[r]);
        ans = Math.min(ans, max);
        l++;
        r++;
      }

      System.out.println(ans - 1);
    }
  }

  private static void bBetter() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int x = sc.nextInt();
      int y = sc.nextInt();

      int xor = x ^ y;
      int count = 0;
      // find the number of zeroes to the right of the first digit which is one
      String s = Integer.toBinaryString(xor);
      for (int i = s.length() - 1; i >= 0; i--) {
        if (s.charAt(i) == '0') {
          count++;
        } else {
          break;
        }
      }

      System.out.println((long) Math.pow(2, count));

    }
    sc.close();
  }

  private static void b() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt(); // Number of test cases
    while (t-- > 0) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      System.out.println(longestCommonSubsequenceLength(x, y));
    }
    sc.close();
  }

  private static int longestCommonSubsequenceLength(int x, int y) {
    int xor = x ^ y;
    return countTrailingZeros(xor);
  }

  private static int countTrailingZeros(int n) {
    int count = 0;
    while ((n & 1) == 0) {
      n >>= 1;
      count++;
    }
    return 1 << count;
  }

  private static void c() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt(); // Number of outcomes
      int[] k = new int[n];

      for (int i = 0; i < n; i++) {
        k[i] = sc.nextInt();
      }

      // Find the smallest k_i
      int minK = Integer.MAX_VALUE;
      for (int i = 0; i < n; i++) {
        if (k[i] < minK) {
          minK = k[i];
        }
      }

      // If minK is 2, it's impossible to find a valid distribution
      if (minK == 2) {
        System.out.println("-1");
        continue;
      }

      // Otherwise, calculate the bets
      int[] bets = new int[n];
      int sumBets = 0;
      for (int i = 0; i < n; i++) {
        bets[i] = 1; // Start with a base bet of 1
        sumBets += bets[i];
      }

      for (int i = 0; i < n; i++) {
        if (sumBets >= (k[i] - 1) * bets[i]) {
          // Calculate the required bet to satisfy the condition
          bets[i] = sumBets / (k[i] - 1) + 1;
        }
      }

      // Recalculate sumBets
      sumBets = 0;
      for (int bet : bets) {
        sumBets += bet;
      }

      boolean valid = true;
      for (int i = 0; i < n; i++) {
        if (sumBets >= k[i] * bets[i]) {
          valid = false;
          break;
        }
      }

      if (valid) {
        for (int bet : bets) {
          System.out.print(bet + " ");
        }
        System.out.println();
      } else {
        System.out.println("-1");
      }
    }
    sc.close();
  }

  public static void main(String[] args) {
    System.out.println(Integer.toBinaryString(57 ^ 37));
  }

}

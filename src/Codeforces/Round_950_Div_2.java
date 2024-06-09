package Codeforces;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map;

public class Round_950_Div_2 {
  private static void a() {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      sc.nextLine();
      String s = sc.nextLine();
      HashMap<Character, Integer> fre = new HashMap<>();
      char[] arr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
      for (int i = 0; i < 7; i++) {
        fre.put(arr[i], 0);
      }
      for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        fre.put(c, fre.getOrDefault(c, 0) + 1);
      }

      int ans = 0;

      Set<Character> keys = fre.keySet();

      for (Character key : keys) {
        int f = fre.get(key);
        if (f < m) {
          ans += (m - f);
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
      int f = sc.nextInt();
      int k = sc.nextInt();
      Integer[] arr = new Integer[n];
      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
      }

      int fav = arr[f - 1];

      Arrays.sort(arr, Collections.reverseOrder());

      if (k == n || arr[k] < fav) {
        System.out.println("YES");
      } else if (arr[k] > fav) {
        System.out.println("NO");
      } else {
        if (arr[k - 1] == fav) {
          System.out.println("MAYBE");
        } else {
          System.out.println("NO");
        }

      }

    }
    sc.close();
  }

  public static void c() {
    Scanner sc = new Scanner(System.in);

    int t = sc.nextInt();
    while (t-- > 0) {

      int n = sc.nextInt();

      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = sc.nextInt();
      }

      int[] b = new int[n];
      for (int i = 0; i < n; i++) {
        b[i] = sc.nextInt();
      }

      int m = sc.nextInt();

      int[] d = new int[m];
      for (int i = 0; i < m; i++) {
        d[i] = sc.nextInt();
      }

      Map<Integer, Integer> cnt1 = new HashMap<>();
      Map<Integer, Integer> cnt2 = new HashMap<>();

      for (int i = 0; i < n; i++) {
        if (a[i] != b[i]) {
          cnt1.put(b[i], cnt1.getOrDefault(b[i], 0) + 1);
        }
      }

      for (int i = 0; i < m; i++) {
        cnt2.put(d[i], cnt2.getOrDefault(d[i], 0) + 1);
      }

      boolean f = true;

      for (Map.Entry<Integer, Integer> entry : cnt1.entrySet()) {
        int x = entry.getKey();
        int y = entry.getValue();
        if (cnt2.getOrDefault(x, 0) < y) {
          f = false;
          break;
        }
      }

      if (Arrays.stream(b).noneMatch(value -> value == d[m - 1])) {
        f = false;
      }

      if (f) {
        System.out.println("YES");
      } else {
        System.out.println("NO");
      }
    }

    sc.close();
  }

  public static void main(String[] args) {
    c();
  }

}

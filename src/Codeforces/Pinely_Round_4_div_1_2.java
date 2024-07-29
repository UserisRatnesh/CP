package Codeforces;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Pinely_Round_4_div_1_2 {
	
	

    public static void A(Scanner sc) {
        int n = sc.nextInt();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if (i % 2 == 0) {
                ans = Math.max(ans, x);
            }
        }

        System.out.println(ans);

    }
    
    public static void B(Scanner sc) {

        int n = sc.nextInt();
        int[] b = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            b[i] = sc.nextInt();
        }

        int[] a = new int[n];
        a[0] = b[0];
        for (int i = 1; i < n - 1; i++) {
            a[i] = b[i - 1] | b[i];
        }

        a[n - 1] = b[n - 2];

        if (n == 2) {
            a[0] = b[0];
            a[1] = b[0];
        }

        boolean isPossible = true;

        for (int i = 0; i < n - 1; i++) {
            if ((a[i] & a[i + 1]) != b[i]) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println(-1);
        }
    
    }
    
    
    public static void C(Scanner sc) {

        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        if (n == 1) {
            System.out.println(1);
            System.out.println(arr[0]);
        } else {
            long ops = 0;
            List<Long> ans = new ArrayList<>();
            for (int i = 0; i < 40; i++) {
                Arrays.sort(arr);
                if (arr[0] == 0 && arr[n - 1] == 0) {
                    break;
                }
                if (arr[0] == arr[n - 1]) {
                    long factor = arr[n - 1];
                    ans.add(factor);
                    ops++;
                    for (int j = 0; j < n; j++) {
                        arr[j] = Math.abs(arr[j] - factor);
                    }
                    break;

                }
                long factor = arr[n - 1] / 2;
                ans.add(factor);
                ops++;

                for (int j = 0; j < n; j++) {
                    arr[j] = Math.abs(arr[j] - factor);
                }
            }

            if (arr[0] == 0 && arr[n - 1] == 0) {
                System.out.println(ops);
                for (Long x : ans) {
                    System.out.print(x + " ");
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }

    
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

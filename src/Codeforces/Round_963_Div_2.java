package Codeforces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


// Solution is per test case

public class Round_963_Div_2 {

	public static void A(Scanner sc) {
		int n = sc.nextInt();
		String s = sc.next();
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		for (int i = 0; i < 4 * n; i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				countA++;
			} else if (c == 'B') {
				countB++;
			} else if (c == 'C') {
				countC++;
			} else if (c == 'D') {
				countD++;
			}
		}

		int ans = Math.min(n, countA) + Math.min(n, countB) + Math.min(n, countC) + Math.min(n, countD);
		System.out.println(ans);
	}


	public static void B(Scanner sc) {
		int n = sc.nextInt();
		long[] arr = new long[n];

		PriorityQueue<Long> evenMinHeap = new PriorityQueue<>(); // stores even only
		PriorityQueue<Long> oddMaxHeap = new PriorityQueue<>(new Comparator<Long>() {
			public int compare(Long a, Long b) {
				return b.compareTo(a);
			}
		});

		PriorityQueue<Long> evenMaxHeap = new PriorityQueue<>(new Comparator<Long>() {
			public int compare(Long a, Long b) {
				return b.compareTo(a);
			}
		});

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
			if (arr[i] % 2 == 0) {
				evenMinHeap.add(arr[i]);
				evenMaxHeap.add(arr[i]);
			} else {
				oddMaxHeap.add(arr[i]);
			}
		}
		int ops = 0;

		if (evenMinHeap.isEmpty() || oddMaxHeap.isEmpty()) {
			System.out.println(ops);
		} else {
			while (!evenMinHeap.isEmpty()) {
				if (evenMinHeap.peek() <= oddMaxHeap.peek()) {
					long newOdd = evenMinHeap.poll() + oddMaxHeap.peek();
					oddMaxHeap.add(newOdd);
					ops++;
				} else {
					long updatedOdd = oddMaxHeap.poll() + evenMaxHeap.peek();
					oddMaxHeap.add(updatedOdd);
					ops++;
				}
			}

			System.out.println(ops);
		}

	}
	
	
	// Brute force, But giving TLE
	public static void C(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        boolean isOkay = false;
        int tempK = 0;

        int ans = -1;

        while (tempK < k) {
            int start = arr[n - 1] + tempK;
            int countOn = 0;
            for (int i = 0; i < n; i++) {
                int quo = (start - arr[i]) / k;
                if (quo % 2 == 0) {
                    countOn++;
                }

            }
            tempK++;
            if (countOn == n) {
                ans = start;
                isOkay = true;
                break;
            }
        }

        if (isOkay) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }

    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

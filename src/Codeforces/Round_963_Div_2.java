package Codeforces;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;


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
	public static void c(Scanner sc) {
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int max = arr[n - 1];
        int M = 2 * k;
        // increase each value untill less than equal to max
        for (int i = 0; i < n; i++) {
            int d = (max - arr[i]) / M;
            arr[i] += d * M;
            assert (arr[i] <= max);
        }
        Arrays.sort(arr);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i] + k, map.getOrDefault(arr[i] + k, 0) - 1);
            map.put(arr[i] + 2 * k, map.getOrDefault(arr[i] + 2 * k, 0) + 1);
            map.put(arr[i] + 3 * k, map.getOrDefault(arr[i] + 3 * k, 0) - 1);
        }

        int ans = -1;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if (count == n) {
                ans = entry.getKey();
                break;
            }
        }

        System.out.println(ans);

    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

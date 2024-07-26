package Codeforces;

import java.util.Scanner;


// Solving per test case

public class Round_962_Div_3 {

	public static void A() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int countAnimals = n / 4;
		int rem = n % 4;
		if (rem != 0) {
			countAnimals++;
		}
		System.out.println(countAnimals);
	}


	// TC = O(k^2)
			// SC = O(n^2 + n/k * n/k)
	public static void B() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine(); // Consume the remaining newline

			char[][] grid = new char[n][n];
			for (int i = 0; i < n; i++) {
				grid[i] = sc.nextLine().toCharArray();
			}

			// Compute reduced grid dimensions
			int reducedSize = n / k;
			char[][] reducedGrid = new char[reducedSize][reducedSize];

			// Fill the reduced grid
			for (int blockRow = 0; blockRow < reducedSize; blockRow++) {
				for (int blockCol = 0; blockCol < reducedSize; blockCol++) {
					// All cells in the k x k block have the same value
					char blockValue = grid[blockRow * k][blockCol * k];
					reducedGrid[blockRow][blockCol] = blockValue;
				}
			}

			// Print the reduced grid
			for (int i = 0; i < reducedSize; i++) {
				for (int j = 0; j < reducedSize; j++) {
					System.out.print(reducedGrid[i][j]);
				}
				System.out.println();
			}
		}

		sc.close();

	}
	
	
	public static void C() {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        String a = sc.next();
        String b = sc.next();
        sc.nextLine();
 
        // Prefix frequency arrays
        int[][] freqA = new int[26][n + 1];
        int[][] freqB = new int[26][n + 1];
 
        // Fill prefix frequency arrays
        for (int i = 0; i < n; i++) {
            char charA = a.charAt(i);
            char charB = b.charAt(i);
            freqA[charA - 'a'][i + 1] = 1;
            freqB[charB - 'a'][i + 1] = 1;
        }
 
        // Build cumulative frequencies
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                freqA[j][i] += freqA[j][i - 1];
                freqB[j][i] += freqB[j][i - 1];
            }
        }
 
        for (int i = 0; i < q; i++) {
            int l = sc.nextInt() - 1; // Convert to 0-based index
            int r = sc.nextInt();
            sc.nextLine();
 
            int ans = 0;
 
            // Calculate frequencies for the range [l, r-1]
            int[] countA = new int[26];
            int[] countB = new int[26];
            for (int j = 0; j < 26; j++) {
                countA[j] = freqA[j][r] - freqA[j][l];
                countB[j] = freqB[j][r] - freqB[j][l];
            }
 
            // Compute the number of changes needed
            for (int j = 0; j < 26; j++) {
                if (countA[j] < countB[j]) {
                    ans += countB[j] - countA[j];
                }
            }
 
            System.out.println(ans);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

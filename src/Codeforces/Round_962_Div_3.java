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

        int[][] prefA = new int[26][n + 1];
        int[][] prefB = new int[26][n + 1];

        for (int i = 1; i <= n; i++) {
            int ca = a.charAt(i - 1) - 'a';
            prefA[ca][i] = 1;
            int cb = b.charAt(i - 1) - 'a';
            prefB[cb][i] = 1;
        }

        // Now cummulate them
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 26; j++) {
                prefA[j][i] += prefA[j][i - 1];
                prefB[j][i] += prefB[j][i - 1];
            }
        }

        for (int i = 0; i < q; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            int ans = 0;
            for (int k = 0; k < 26; k++) {
                int countA = prefA[k][r] - prefA[k][l - 1];
                int countB = prefB[k][r] - prefB[k][l - 1];
                if (countA < countB) {
                    ans += countB - countA;
                }
            }
            System.out.println(ans);

        }
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

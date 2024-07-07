package Codeforces;

import java.util.*;

public class Round_956_Div_2 
{
	
	
	private static void a() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
 
            for (int i = 1; i <= n; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        sc.close();
    }
 
	
	public static void b() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            int[][] a = new int[rows][cols];
            int[][] b = new int[rows][cols];

            // Read gridA
            for (int i = 0; i < rows; i++) {
                String row = scanner.next();
                for (int j = 0; j < cols; j++) {
                    a[i][j] = row.charAt(j) - '0';
                }
            }

            // Read gridB
            for (int i = 0; i < rows; i++) {
                String row = scanner.next();
                for (int j = 0; j < cols; j++) {
                    b[i][j] = row.charAt(j) - '0';
                }
            }

            // Check if transformation is possible
            if (canTransform(a, b, rows, cols)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    private static boolean canTransform(int[][] gridA, int[][] gridB, int rows, int cols) {
        for (int row = rows - 1; row >= 1; --row) {
            for (int col = cols - 1; col >= 1; --col) {
                if (gridA[row][col] != gridB[row][col]) {
                    int diff = (gridB[row][col] - gridA[row][col] + 3) % 3;
                    gridA[row][col] = gridB[row][col];
                    gridA[row - 1][col] = (gridA[row - 1][col] + 2 * diff) % 3;
                    gridA[row][col - 1] = (gridA[row][col - 1] + 2 * diff) % 3;
                    gridA[row - 1][col - 1] = (gridA[row - 1][col - 1] + diff) % 3;
                }
            }
        }

        for (int row = 0; row < rows; ++row) {
            if (gridA[row][0] != gridB[row][0]) {
                return false;
            }
        }

        for (int col = 0; col < cols; ++col) {
            if (gridA[0][col] != gridB[0][col]) {
                return false;
            }
        }

        return true;
    }

	public static void main(String[] args) 
	{
		
	}

}

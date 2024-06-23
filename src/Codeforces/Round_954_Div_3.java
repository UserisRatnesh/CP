package Codeforces;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Round_954_Div_3 
{

	private static void a()
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while(t-->0)
		{
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			int x3 = sc.nextInt();

			int min = Math.min(x1,  Math.min(x2, x3));
			int max = Math.max(x1, Math.max(x2, x3));

			if(x1 != min && x1 != max)
			{
				System.out.println(x1-min + max-x1);
			}
			else if(x2 != min && x2 != max)
			{
				System.out.println(x2-min + max-x2);
			}
			else
			{
				System.out.println(x3-min + max-x3);
			}
		}
	}

	private static void b()
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while(t-->0)
		{
			int row = sc.nextInt();
			int col = sc.nextInt();
			int[][] arr = new int[row][col];
			for(int i=0; i<row; i++)
			{
				for(int j=0; j<col; j++)
				{
					arr[i][j] = sc.nextInt();
				}
			}


			for(int i=0; i<row; i++)
			{
				for(int j=0; j<col; j++)
				{

					int ele = arr[i][j];
					int maxPadoshi = Integer.MIN_VALUE;
					int[] xDir = {0, -1, 0, 1 };
					int[] yDir = {-1, 0, 1, 0};
					for(int idx=0; idx<4; idx++) 
					{
						int newRow = i+xDir[idx];
						int newCol = j+yDir[idx];
						if(newRow >= 0 && newRow < row && newCol >= 0 && newCol < col)
						{
							maxPadoshi = Math.max(maxPadoshi, arr[newRow][newCol]);
						}
					}

					if(ele > maxPadoshi)
					{
						System.out.print(maxPadoshi+" ");
					}
					else
					{
						System.out.print(ele+" ");
					}

				}
				System.out.println();
			}
		}

	}


	private static void c()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			StringBuilder s = new StringBuilder(sc.next());
			sc.nextLine();
			int[] arr = new int[m];
			for(int i=0; i<m; i++)
			{
				arr[i] = sc.nextInt();
			}

			String[] c = sc.next().split("");

			Arrays.sort(arr);
			Arrays.sort(c);

			int i = 0;
			int ci = 0;
			while(i < m && ci < m)
			{
				int index = arr[i];
				s.setCharAt(index-1, c[ci++].charAt(0));

				while(i+1 < m && arr[i+1] == index)
				{
					i++;
				}
				i++;
			}	

			System.out.println(s.toString());
		}
		sc.close();
	}

	private static void d() {
	    Scanner sc = new Scanner(System.in);

	    int t = sc.nextInt();
	    while (t-- > 0) {
	        int n = sc.nextInt();
	        String str = sc.next();
	        
	        if (n - 2 <= 0) {
	            long ans = 0;
	            for (int i = 0; i < n; i++) {
	                ans += Long.parseLong(str.charAt(i) + "");
	            }
	            System.out.println(ans);
	            continue;
	        }

	        if (n - 2 == 1) {
	            long start = Long.parseLong(str.charAt(0) + "");
	            long end = Long.parseLong(str.charAt(n - 1) + "");
	            if (start == 0 || end == 0) {
	                System.out.println(0);
	                continue;
	            }
	        }

	        // Find if a single zero then return zero
	        boolean hasZero = false;
	        for (int i = 0; i < n; i++) {
	            long val = Long.parseLong(str.charAt(i) + "");
	            if (val == 0) {
	                System.out.println(0);
	                hasZero = true;
	                break;
	            }
	        }
	        if (hasZero) continue;

	        // Find the min pair value
	        long minPair = Long.parseLong(str.substring(0, 2));
	        int minPStart = 0;
	        int minPEnd = 1;
	        for (int i = 0; i < n - 1; i++) {
	            long pair = Long.parseLong(str.substring(i, i + 2));
	            if (pair < minPair) {
	                minPair = pair;
	                minPStart = i;
	                minPEnd = i + 1;
	            }
	        }

	        long ans = 0;
	        for (int i = 0; i < n; i++) {
	            if (i < minPStart || i > minPEnd) {
	                ans += Long.parseLong(str.charAt(i) + "");
	            }
	        }

	        ans += minPair;

	        System.out.println(ans);
	    }
	    
	    sc.close();
	}



	public static void main(String[] args) 
	{
		d();

	}

}

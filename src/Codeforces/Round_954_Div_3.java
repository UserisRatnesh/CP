package Codeforces;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

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

			System.out.println(max-min);
		}
		sc.close();
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

			int[] arr = new int[m];
			TreeSet<Integer> set = new TreeSet<>();
			for(int i=0; i<m; i++)
			{
				set.add(sc.nextInt());
			}

			char[] c = sc.next().toCharArray();

			Arrays.sort(c);

			int i = 0;
			int ci = 0;
			while(!set.isEmpty())
			{
				int index = set.first();
				set.remove(index);
				s.setCharAt(index-1, c[ci++]);
			}

			System.out.println(s.toString());
		}
		sc.close();
	}

	private static void d() 
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) 
		{
			int n = sc.nextInt();
			String str = sc.next();

			System.out.println(dHelper(n, str));
		}

		sc.close();
	}
	
	private static long dHelper(int n, String s)
	{
		if(n == 2)	return Long.parseLong(s);
		
		long ans = Integer.MAX_VALUE;
		// Iterate over each possible pair
		for(int i=0; i<n-1; i++) // O(n)
		{
			long currAns = 0;
			
			long pair = Long.parseLong(s.substring(i,i+2));
			
			// Iterate from 0 to i-1 and add all values except one
			// if zero is found return zero
			for(int j=0; j<i; j++) // O(i)
			{
				long value = s.charAt(j)-'0';
				if(value == 0)	return 0;
				else if(value != 1)	currAns+= value;
			}
			
			for(int j=i+2; j<n; j++) // O(n-i)
			{
				long value = s.charAt(j)-'0';
				if(value == 0)	return 0;
				else if(value != 1)	currAns+= value;
			}
			
			if(pair != 1)	currAns += pair;
			if(currAns == 0)	currAns = 1;
			ans = Math.min(currAns, ans);
		}
		
		return ans;
	}



	public static void main(String[] args) 
	{
		d();
	}

}

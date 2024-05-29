package Codeforces;

import java.util.Scanner;

public class B1966_use 
{
	
	private static void f() 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			sc.nextLine();
			String[][] arr = new String[n][m];
			for(int i=0; i<n; i++)
			{
				String s = sc.nextLine();
				for(int j=0; j<m; j++)
				{
					arr[i][j] = s.charAt(j)+"";
				}
			}
			
			// iterate over first row and last row
			// and if first row squares is of same color and last row squares are also of same 
			// color And the both color are different then answer is no
			
			//first row
			boolean firstRowSameColor = true;
			for(int j=0; j<m; j++)
			{
				if(!arr[0][0].equals(arr[0][j]))
				{
					firstRowSameColor = false;
					break;
				}
			}
			
			// last row
			boolean lastRowSameColor = true;
			for(int j=0; j<m; j++)
			{
				if(!arr[n-1][0].equals(arr[n-1][j]))
				{
					lastRowSameColor = false;
					break;
				}
			}
			
			
			
			// do the above for first column and last column
			// first col
			boolean firstColSameColor = true;
			for(int i=0; i<n; i++)
			{
				if(!arr[0][0].equals(arr[i][0]))
				{
					firstColSameColor = false;
					break;
				}
			}
			
			// last row
			boolean lastColSameColor = true;
			for(int i=0; i<n; i++)
			{
				if(!arr[0][m-1].equals(arr[i][m-1]))
				{
					lastColSameColor = false;
					break;
				}
			}
			
			if((firstRowSameColor && lastRowSameColor && !arr[0][0].equals(arr[n-1][0])) || (firstColSameColor && lastColSameColor && !arr[0][0].equals(arr[0][m-1])))
			{
				System.out.println("No");
			}
			else
			{
				System.out.println("Yes");
			}
		}
		
	}

	public static void main(String[] args) 
	{
		f();
	}

}

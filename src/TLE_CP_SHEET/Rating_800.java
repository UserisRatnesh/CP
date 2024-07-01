package TLE_CP_SHEET;

import java.util.Scanner;

public class Rating_800 
{
	
	private static void A1903()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			// If already sorted then yes
			boolean isSorted = true;
			int prev = sc.nextInt();
			for(int i=1; i<n; i++)
			{
				int x = sc.nextInt();
				if(prev <= x)	prev = x;
				else	isSorted = false;
			}
			
			if(k > 1 || isSorted)	System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	private static void A1901()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int x = sc.nextInt();
			
			int prev = 0;
			int maxDiff = 0;
			for(int i=0; i<n; i++)
			{
				int input = sc.nextInt();
				maxDiff = Math.max(maxDiff, input-prev);
				prev = input;
			}
			
			maxDiff = Math.max(maxDiff, 2*(x-prev));
			
			System.out.println(maxDiff);
		}
	}

	private static void A1900()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			String s = sc.next();
			
			int ans = 0;
			
			int grpLength = 0;
			boolean isThreeLength = false;
			for(int i=0; i<n; i++)
			{
				int c = s.charAt(i);
				if(c == '.') 
				{
					grpLength++;
					if(grpLength == 3) 
					{
						isThreeLength = true;
						break;
					}
				}
				else
				{
					ans += grpLength;
					grpLength = 0;
				}
			}
			
			if(isThreeLength)	System.out.println(2);
			
			else System.out.println(ans + grpLength);
		}
	}
	
	
	private static void A1899()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			
			if(n % 3 == 0)	System.out.println("SECOND");
			else System.out.println("FIRST");
		}
		sc.close();
	}
	
	
	public static void main(String[] args) 
	{
		A1899();
	}

}

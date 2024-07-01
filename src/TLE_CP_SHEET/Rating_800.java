package TLE_CP_SHEET;

import java.util.TreeMap;
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
	
	private static void A1896()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int first = sc.nextInt();
			int min = first;
			for(int i=1; i<n; i++)
			{
				int input = sc.nextInt();
				min = Math.min(input, min);
			}
			
			if(min == first)	System.out.println("YES");
			else	System.out.println("NO");
		}
		sc.close();
	}
	
	
	private static void A1890()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for(int i=0; i<n; i++)
			{
				int input = sc.nextInt();
				map.put(input, map.getOrDefault(input, 0)+1);
			}
			
			if(map.size() > 2)	System.out.println("NO");
			else if(map.size() == 1)	System.out.println("Yes");
			else 
			{
				int first = map.get(map.firstKey());
				int second = map.get(map.lastKey());
				if(Math.floor(n/2) ==  first || Math.floor(n/2) == second) System.out.println("YES");
				else System.out.println("NO");
			}
		}
		sc.close();
	}
	
	
	private static void A1881()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			String x = sc.next();
			String s = sc.next();
			// what is the maximum answer possible
			// 5
			boolean isSubstr = false;
			int ans = 0;
			for(int i=0; i<=5; i++)
			{
				if(x.contains(s))
				{
					isSubstr = true;
					ans = i;
					break;
				}
				
				x += x;
			}
			
			if(isSubstr)	System.out.println(ans);
			else	System.out.println(-1);
			
		}
		sc.close();
	}
	
	private static boolean bSubtringOfa(String a, String b)
	{
		int n1 = a.length();
		int n2 = b.length();
		if(n1 < n2)	return false;
		
		int i1 = 0;
		int i2 = 0;
		while(i1 < n1 && i2 < n2)
		{
			int c1 = a.charAt(i1);
			int c2 = b.charAt(i2);
			if(c1 == c2)
			{
				i1 ++;
				i2 ++;
				while(i1 < n1 && i2 < n2)
				{
					if(a.charAt(i1) != b.charAt(i2))	return false;
					i1++;
					i2++;
				}
			}
			else i1++;
		}
		
		if(i2 == n2)	return true;
		return false;
	}
	
	public static void main(String[] args) 
	{
		A1881();
	}

}

package Codeforces;

import java.util.Scanner;

public class A1958_use 
{
	private static void f()
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			
			System.out.println(helper(n));
		}
		sc.close();
	}
	
	private static int helper(int n)
	{
		if(n<3)
		{
			return n;
		}
		
		// pay using 5
		int five = Integer.MAX_VALUE;
		if(n>=5)
		{
			five = helper(n-5);
		}
		
		int three = helper(n-3);
		
		return Math.min(five, three);
	}

	public static void main(String[] args) 
	{
		
		f();
	}

}

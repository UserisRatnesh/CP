package Codeforces;

import java.util.HashSet;
import java.util.Scanner;

public class D1915_use 
{
	private static void f()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.next();
			
			int r = n-1;
			
			// To keep track of index just after which split is done
			HashSet<Integer> set = new HashSet<>();
			while(r >= 0)
			{
				if(s.charAt(r) == 'a' || s.charAt(r) == 'e')
				{
					r -= 2;
				}
				else
				{
					r -= 3;
				}
				set.add(r);
			}
			
			// iterate over string and print dots
			for(int i=0; i<n; i++)
			{
				System.out.print(s.charAt(i));
				if(set.contains(i))
				{
					System.out.print(".");
				}
			}
			System.out.println();
		}
		sc.close();
	}

	public static void main(String[] args) 
	{
		f();

	}

}

package Codeforces;

import java.util.Scanner;

public class A282_use 
{
	
	private static void f() 
	{
		Scanner sc = new Scanner(System.in);
		
		long ans = 0;
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0; i<n; i++)
		{
			String s = sc.nextLine();
			if(s.charAt(0) == '-' || s.charAt(1) == '-')
			{
				ans--;
			}
			else
			{
				ans++;
			}
		}
		
		System.out.println(ans);
	}

	public static void main(String[] args) 
	{
		f();
	}

}

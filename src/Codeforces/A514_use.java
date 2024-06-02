package Codeforces;

import java.util.Scanner;

public class A514_use 
{
	private static void f() 
	{
		Scanner sc = new Scanner(System.in);
		
		long ans = 0;
		String x = sc.next();
		
		StringBuilder sb = new StringBuilder(x);
		
		for(int i=0; i<sb.length(); i++)
		{
			
		    // This is done because we do not want to reduce number of digits of a number
		    if( i == 0 && sb.charAt(i) == '9')
		    {
		        continue;
		    }
			if(sb.charAt(i) > 52)
			{
				// invert digits
				char c =(char)(57-sb.charAt(i)+48);
				sb.setCharAt(i, c);
			}
		}
		
		ans = Long.parseLong(sb.toString());
		
		
		
		System.out.println(ans);
		sc.close();
	}


	public static void main(String[] args) 
	{
		f();
	}

}

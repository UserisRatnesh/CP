package Codeforces;

import java.util.Scanner;


public class Educational_Round_167_Div_2 
{

	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0; i<n; i++)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(y < -1)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
		}
		sc.close();
	}
	
	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			String a = sc.next();
			String b = sc.next();
			
			int l1 = a.length();
			int l2 = b.length();
			
			int ans = l1 + l2;
			
			// b = x + c + y
			// i tells the length of prefix x and start of c
			for(int i=0; i<l2; i++)
			{
				int j = i;
				for(int c = 0; c<l1; c++)
				{
					if(j < l2 && a.charAt(c) == b.charAt(j))	j++;
				}
				
				ans = Math.min(ans,  l1+l2-(j-i));
			}
			
			System.out.println(ans);
			
			
		}
		sc.close();
	}
	


	public static void main(String[] args) 
	{
		b();
	}

}

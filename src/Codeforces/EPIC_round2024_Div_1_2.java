package Codeforces;


import java.util.Scanner;


public class EPIC_round2024_Div_1_2 
{
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();

			int ans = n*k;
			if(k >1)	ans -= (k-1);

			System.out.println(ans);
		}
		sc.close();
	}

	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();

			long coins = 0;

			int prev = sc.nextInt();
			int op = 0;

			for(int i=1; i<n; i++)
			{
				int x = sc.nextInt();
				if(x < prev)
				{
					int diff = prev-x;
					if(diff < op)
					{
						coins += diff;
					}
					else
					{
						coins += op;
						diff -= op;
						op += diff;
						coins += 2*diff;
					}
				}
				if(x > prev) prev = x;
			}

			System.out.println(coins);

		}
		sc.close();
	}


	private static void c()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			
			int max = 0;

			for(int i=0; i<n; i++)
			{
				int x = sc.nextInt();
				max = Math.max(max,  x+i);
			}
			
			System.out.println(max);

			
		}
		sc.close();
	}
	



	public static void main(String[] args) 
	{
		c();

	}

}

package Codeforces;

import java.util.Scanner;

public class C1968_use {

	public static void main(String[] args) 
	{
		f();
	}
	
	private static void f()
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t--> 0)
		{
			int n = sc.nextInt();
			int[] x = new int[n-1];
			
			for(int i=0; i<n-1; i++)
			{
				x[i] = sc.nextInt();
			}
			
			int[] a = new int[n];
			
			// choose the first element such that it is greater than first element of x array 
			// so that it can give the x2 as modulo
			a[0] = x[0]+1;
			System.out.print(a[0]+" ");
			
			for(int i=0; i<n-1; i++)
			{
				// find the number whose modulo by previous gives present x and greater than next x.
				
				// curr x
				int currX = x[i];
				
				//if next x exist
				int aiPlus1 = -1;
				if(i+1 < n-1)
				{
					aiPlus1 = x[i+1]+1;
					if(currX + a[i] >= aiPlus1)
					{
						aiPlus1 = currX+a[i];
					}
					else 
					{
						while(aiPlus1 % a[i] != currX)
						{
							aiPlus1++;
						}
					}
				}
				if(aiPlus1 == -1)
				{
					a[i+1] = a[i]+currX;
				}
				else
				{
					a[i+1] = aiPlus1;
				}
				System.out.print(a[i+1]+" ");
				
				
			}
			
			
			System.out.println();
		}
		
	}

}

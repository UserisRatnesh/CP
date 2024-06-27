package Codeforces;

import java.util.Scanner;

public class B1831_use 
{

	private static void f() 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];

			for(int i=0; i<n; i++)
			{
				a[i] = sc.nextInt();
			}

			for(int i=0; i<n; i++)
			{
				b[i] = sc.nextInt();
			}
			
			int[] count1 = new int[2*n+1];
			int[] count2 = new int[2*n+1];
			
			for(int i=0; i<n; i++)
			{
				int j = i;
				while(j<n && a[j] == a[i])	j++;
				
				count1[a[i]] = Math.max(count1[a[i]], j-i);
				
				i = --j;
			}
			
			for(int i=0; i<n; i++)
			{
				int j = i;
				while(j<n && b[j] == b[i])	j++;
				
				count2[b[i]] = Math.max(count2[b[i]], j-i);
				
				i = --j;
			}
			
			
			int ans = 0;
			for(int i=0; i<2*n+1; i++)
			{
				int temp = count1[i] + count2[i];
				ans = Math.max(ans,  temp);
			}
			
			System.out.println(ans);
			

		}
		sc.close();

	}

	public static void main(String[] args) 
	{
		f();
	}

}

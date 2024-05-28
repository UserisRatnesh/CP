package Codeforces;

import java.util.Scanner;

public class C1931 
{
	private static void f()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i=0; i<n; i++)
			{
				a[i] = sc.nextInt();
			}
			
			int prefLen = 0;
			int left = 0;
			while(left < n && a[left] == a[0])
			{
				prefLen++;
				left++;
			}
			
			int suffLen = 0;
			int right = n-1;
			while(right >= 0 && a[right] == a[n-1])
			{
				suffLen++;
				right--;
			}
			
			int lenToSub = 0;
			if(a[0] == a[n-1])
			{
				lenToSub = prefLen + suffLen;
			}
			else
			{
				lenToSub = Math.max(prefLen, suffLen);
			}
			
			if(lenToSub > n)
			{
				System.out.println(0);
			}
			else
			{
				System.out.println(n-lenToSub);
			}
			
			
			
		}
	}

	public static void main(String[] args) 
	{
		f();

	}

}

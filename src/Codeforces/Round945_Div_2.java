package Codeforces;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Round945_Div_2 
{
	
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t --> 0)
		{	
			int p1 = sc.nextInt();
			int p2 = sc.nextInt();
			int p3 = sc.nextInt();
			
			if ((p1 + p2 + p3) % 2 != 0) {
	            // If the total points are odd then score not possible
	            System.out.println(-1);
	        } else {
	            int sum = p1 + p2 ;
	            int maxDraws = Math.min(sum, p3);
	            if(sum-p3 > 0)
	            {
	            	maxDraws += Math.abs(sum-p3)/2;
	            }
	            System.out.println(maxDraws);
	        }
			
			
		}
		sc.close();
	}
	
	
	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t --> 0)
		{	
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextInt();
			}
			
			bHelper(arr, n);
			
			
		}
		sc.close();
	}
	
	private static void bHelper(int[] arr, int n)
	{
		int k = 1;
		while(k<n)
		{
			int or = 0;
			for(int i=0; i<k; i++)
			{
				or = or | arr[i];
			}
			
			int tempOr = 0; 
			
			for(int i=0; i<n; i++)
			{
				int countK = 0;
				
				int j = i;
				while(countK<k && j<n)
				{
					tempOr = tempOr | arr[j];
					
					countK++;
					j++;
				}
				
				tempOr = 0;
			}
			
			if(tempOr == or)
			{
				System.out.println(k);
				return;
			}
			
			k++;
		}
		
		System.out.println(n);
		return;
		
	}

	
	private static void c()
	{
		
	}
	
	private static void cHelper()
	{
		
	}


	public static void main(String[] args) 
	{
		b();

	}

}

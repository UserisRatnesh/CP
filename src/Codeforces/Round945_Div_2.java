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
			
			
		}
		sc.close();
	}
	
	
	


	public static void main(String[] args) 
	{
		b();

	}

}

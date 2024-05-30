package Codeforces;

import java.util.Scanner;


public class B1957_Use 
{
	
	private static void f(int n, int k)
	{
		if(n == 1)
		{
			System.out.println(k);
			return;
		}
		// find the largest value possible that is of the form 2^x - 1
		// Because this will give the largest number of ones
		int val = maxPowerOfTwo(k+1)-1;
		
		System.out.print(val+" ");
		System.out.print(k-val +" ");
		for(int i=3; i<=n; i++)
		{
			System.out.print(0+" ");
		}
		System.out.println();
		
	}
	
	public static int maxPowerOfTwo(int n) 
	{
		int result = 1;
		while(result < n)
		{
			result<<=1;
		}
		return result >> 1;
    }

	
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			f(n, k);
		}
		sc.close();
//		System.out.println(Integer.toBinaryString(32));
//		System.out.println(Integer.toBinaryString(19));
//		System.out.println(Integer.toBinaryString(31));
//		System.out.println(Integer.toBinaryString(20));
		
	}

}

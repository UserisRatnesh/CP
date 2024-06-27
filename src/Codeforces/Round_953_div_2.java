package Codeforces;

import java.util.Scanner;

public class Round_953_div_2 
{

	private static void a()
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while(t--> 0)
		{
			int n = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			for(int i=2; i<n; i++)
			{
				int a = sc.nextInt();
				if(l < r)
				{
					l = a;
				}
				else
				{
					r = a;
				}

			}

			System.out.println(l+r);
		}
		sc.close();
	}

	private static void b()
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while(t--> 0)
		{
			long n = sc.nextInt();
			long a = sc.nextInt();
			long b = sc.nextInt();
			System.out.println(bHelper(n, a, b));
		}
		sc.close();
	}

	private static long bHelper(long n, long a, long b)
	{
		if (a > b)
		{
			return n * a;
		}

		long sum = 0;

		// Sum prices from b down to the maximum possible price >= a
		long count = b - a + 1;
		if (count > n) {
			count = n; // all buns sold at modified price
		}

		// Sum of first count terms from b down to b - count + 1
		sum = (count * (2 * b - count + 1)) / 2; // sum of first n terms of AP => n*(a+l)/2, here l = b-count+1

		// For the remaining items, use price a
		if (n > count) {
			sum += (n - count) * a;
		}

		return sum;
	}
	
	private static void c()
	{
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while(t--> 0)
		{
			int n = sc.nextInt();
			long k = sc.nextLong();
			int[] nums = new int[n];
			
			for(int i=1; i<=n; i++)
			{
				nums[i-1] = i;
			}
			
			long req = k;
			int left = 0;
			int right = n-1;
			
			while(left < right)
			{
				int swapK = 2*Math.abs((nums[left]-nums[right]));
				
				if(swapK <= req)
				{
					req -= swapK;
					
					// do swap
					int temp = nums[left];
					nums[left] = nums[right];
					nums[right] = temp;
					left++;
					right--;
				}
				else
				{
					left++;
				}
				
				if(req == 0)
				{
					break;
				}
				
			}

			if(req == 0)
			{
				System.out.println("YES");
				for(int i=0; i<n; i++)
				{
					System.out.print(nums[i]+" ");
				}
				System.out.println();
			}
			else
			{
				System.out.println("NO");
			}
			
			
			
		}
		sc.close();
	}

	
	

	public static void main(String[] args) 
	{
		c();
	}

}

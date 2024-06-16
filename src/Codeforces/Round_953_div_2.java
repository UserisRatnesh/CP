package Codeforces;

import java.util.ArrayList;
import java.util.List;
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
			
			permute(n, k);
			
		}
		sc.close();
	}

	public static void permute(int n, long k) {

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		List<List<Integer>> ans = new ArrayList<>();

		if(permuteHelper(list, new ArrayList<>(), k , ans))
		{
			System.out.println("YES");
			for(List<Integer> l : ans)
			{
				for(Integer x : l)
				{
					System.out.print(x+" ");
				}
			}
			System.out.println();
		}
		else
		{
			System.out.println("No");
		}
	}

	private static boolean permuteHelper(List<Integer> numsList, List<Integer> list, long k , List<List<Integer>> ans) 
	{
		
		int n = numsList.size();
		if (n == 0) {

			long sum = 0;
			for(int i=1; i<=list.size(); i++)
			{
				sum = Math.abs(list.get(i-1) - i);
			}
			
			if(sum == k)
			{
				ans.add(list);
				return true;
			}
			return false;
		}

		for (int i = 0; i < n; i++) {
			int ele = numsList.get(i);
			List<Integer> newList = new ArrayList<>(list);
			newList.add(ele);
			List<Integer> newNumList = new ArrayList<>(numsList);
			newNumList.remove(i);
			if(permuteHelper(newNumList, newList, k, ans))
			{
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) 
	{
		c();
	}

}

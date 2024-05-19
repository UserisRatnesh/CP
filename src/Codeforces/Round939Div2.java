package Codeforces;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.HashMap;

public class Round939Div2 
{
	
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int k = sc.nextInt();
			int q = sc.nextInt();
			
			int[] arr = new int[k];
			for(int i=0; i<k; i++)
			{
				arr[i] = sc.nextInt();
			}
			
			int[] narr = new int[q];
			for(int i=0; i<q; i++)
			{
				narr[i] = sc.nextInt();
			}
			for(int i=0; i<q; i++)
			{
				System.out.print(aHelper(narr[i], arr)+" ");
			}
			System.out.println();
			t--;
		}
		sc.close();
		
	}
	
	private static int aHelper(int n, int[] arr)
	{
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++)
		{
			list.add(i);
		}
		
		
		while(list.size() >= arr[0])
		{
			for(int i=arr.length-1; i>=0; i--)
			{
				int index = arr[i]-1;
				if(index < list.size())
				{
					list.remove(index);
				}
			}
		}
		
		return list.size();
	}
	
	
	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextInt();
			}
			
			System.out.println(bHelper(n, arr));
			
			t--;
		}
		sc.close();
		
	}
	
	private static int bHelper(int n, int[] arr)
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		for(int x : arr)
		{
			int f = map.getOrDefault(x, 0)+1;
			map.put(x, f);
			if(f == 2)
			{
				ans++;
			}
			
		}
		return ans;
	}
	
	
//	private static int mex(int[] arr, int l, int r)
//	{
//		
//	}
	
	private static void f()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			int[] left = new int[n];
			int[] right = new int[n];
			for(int i=0; i<n; i++)
			{
				left[i] = sc.nextInt();
				right[i] = sc.nextInt();
			
			}
			
			System.out.println(fHelper(n, left, right));
			t--;
			
		}
	}
	
	private static int fHelper(int n, int[] left, int[] right)
	{
		HashMap<Integer, Boolean> map = new HashMap<>();
		int ans = 0;
		for(int i=0; i<n; i++)
		{
			if(map.containsKey(i))
			{
				continue;
			}
			map.put(i, true);
			ans += 1;
			
			int prev = i;
			
			for(int j=0; j<n; j++)
			{
				if(map.containsKey(j))
				{
					continue;
				}
				
				int diff = Math.abs(prev-j);
				int leftSum = left[prev]+left[j];
				int rightSum = right[prev] + right[j];
				
				if(diff >= leftSum && diff <= rightSum && !map.containsKey(j))
				{
					map.put(j, true);
					prev = j;
					
				}
			}
			
			for(int j=n-1; j>=0; j--)
			{
				if(map.containsKey(j))
				{
					continue;
				}
				
				int diff = Math.abs(prev-j);
				int leftSum = left[prev]+left[j];
				int rightSum = right[prev] + right[j];
				
				if(diff >= leftSum && diff <= rightSum && !map.containsKey(j))
				{
					map.put(j, true);
					prev = j;
					
				}
			}
		}
		
		return ans;
	}
	
	public static void fun()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int n = sc.nextInt();
            fun2(n);
            t--;
        }
        sc.close();
        
        
    }
    
    private static void fun2(int n)
    {
        int maxSum = 0;
        for(int i=1; i<=n; i++)
        {
            maxSum += i*(2*i-1);
        }
        
        System.out.print(maxSum+" ");
        System.out.println(2*n);
        for(int i=n; i>=1; i--)
        {
            System.out.print(1+" "+i+" ");
            for(int j=1; j<=n; j++)
            {
                System.out.print(j+" ");
            }
            System.out.println();
            System.out.print(2+" "+i+" ");
            for(int j=1; j<=n; j++)
            {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
	
	public static void main(String args[])
	{
		fun();
	}

}

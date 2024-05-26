package Codeforces;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Round_948_Div_2 
{
	static HashMap<String ,Boolean> memo = new HashMap<>();
	
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(helper(n, m, 0) ) {
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			
			memo.clear();
			
		}
		sc.close();
	}
	
	private static boolean helper(int n, int m, int count)
	{
		//base case
		// if not returned true yet -> means false
		if(n == 0)
		{
			if(count == m)
			{
				return true;
			}
			return false;
		}
		
		String key = n+""+count;
		if(memo.containsKey(key))
		{
			return memo.get(key);
		}
		
		// take
		boolean add = helper(n-1, m, count+1);
		
		// not take
		boolean remove = false;
		if(count > 0) {
			remove = helper(n-1, m, count-1);
		}
		
		if(add || remove)
		{
			memo.put(key, true);
			return true;
		}
		memo.put(key, false);
		return false;
	}

	static HashSet<Integer> set = new HashSet<>();
	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int x = sc.nextInt();
			
			int[] a = new int[32];
			// find the i which results in the value just greater than x
			int justGreaterI = justGreater(0, x);
			a[justGreaterI] = 1;
			
			double currValue = Math.pow(2, justGreaterI);
			
			double req = Math.pow(2 , justGreaterI) - x;
			
			while(req != 0)
			{
				
				int i = getI(0, (int)req );
				if(i == -1)
				{
					i = justGreater(0, (int)req);
				}
				
				if(currValue > x)
				{
					// sub
					a[i] = -1;
					currValue = currValue - Math.pow(2, i);
				}
				else
				{
					a[i] = 1;
					currValue = currValue +  Math.pow(2, i);
				}
				
				req = Math.abs(currValue - x); 
				
			}
			
			
			// it is having two or more consecutive non zero
			System.out.println(32);
			for(int i=0; i< 32; i++)
			{
				System.out.print(a[i] +" ");
			}
			System.out.println();
			
			set.clear();
		}
		sc.close();
	}
	
	private static int justGreater(int i, int value) {
        // Base case
        if (i == 32) {
            return -1;
        }
        
        if (Math.pow(2, i) >= value && !isAdjacentInSet(i)) {
            set.add(i);
            return i;
        }
        return justGreater(i + 1, value);
    }
    
    private static int getI(int i, int req) {
        // Base case
        if (i == 32) {
            return -1;
        }
        
        if (Math.pow(2, i) == req && !isAdjacentInSet(i)) {
            set.add(i);
            return i;
        }
        return getI(i + 1, req);
    }
    
    private static boolean isAdjacentInSet(int i) {
        return set.contains(i) || set.contains(i + 1) || set.contains(i - 1);
    }
	
	
	
	public static void main(String[] args) 
	{
		b();
	}

}

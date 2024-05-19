package Codeforces;

import java.util.HashMap;
import java.util.Scanner;

public class Round938Div3 
{
	
	private static void d()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n];
			for(int i=0; i<n; i++)
			{
				a[i] = sc.nextInt();
			}
			
			HashMap<Integer, Integer> b = new HashMap<>();
			HashMap<Integer, Integer> bcopy = new HashMap<>();
			for(int i=0; i<m; i++)
			{
				int x = sc.nextInt();
				b.put(x,  b.getOrDefault(x, 0)+1);
				bcopy.put(x,  bcopy.getOrDefault(x, 0)+1);
			}
			
			System.out.println(dHelper(n, m, k, a, b ,bcopy));
			t--;
		}
	}
	
	private static int dHelper(int n, int m, int k, int[] a, HashMap<Integer, Integer> b, HashMap<Integer, Integer> bcopy)
	{
		int ans = 0;
		for(int i=0; i<n; i++)
		{
			int count = 0;
			b.clear();
			b.putAll(bcopy);
			for(int j=i; j< (i+m) && j<n; j++)
			{
				int x = a[j];
				if(b.containsKey(x) && b.get(x)!= 0)
				{
					b.put(x,  b.get(x)-1);
					count++;
				}
			}
			if(count >= k)
			{
				ans++;
			}
		}
		
		return ans;
	}
	
	private static void c()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextInt();
			}
			System.out.println(cHelper(n, k, arr));
			t --;
		}
	}
	
	
	private static int cHelper(int n, int k, int[] arr)
	{
		int left = 0;
		int right = n-1;
		
		int ans = 0;
		
		boolean leftAttack = true;
		 
		while(k != 0 && left <= right)
		{
			if(leftAttack)
			{
				arr[left] = arr[left]-1;
				if(arr[left] == 0)
				{
					left++;
					ans++;
				}
				leftAttack = !leftAttack;
			}
			else
			{
				arr[right] = arr[right]-1;
				if(arr[right] == 0)
				{
					right--;
					ans++;
				}
				leftAttack = !leftAttack;
			}
			k--;
			
		}
		
		return ans;
	}
	
	
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			HashMap<Integer,Integer> dp = new HashMap<>();
			System.out.println(aHelper(n, a, b, dp));
			t --;
		}
	}
	
	private static int aHelper(int n, int a, int b, HashMap<Integer,Integer> dp)
	{
		if(n == 0)
		{
			return 0;
		}
		
		if(dp.containsKey(n)) {
			return dp.get(n);
		}
		
		int ans = 0;
		
		if(n>=2)
		{
			int one = a + aHelper(n-1, a, b, dp);

			int two = b + aHelper(n-2, a, b, dp);
			ans = Math.min(one, two);
			dp.put(n,  ans);
			return ans;
		}
		
		ans = a + aHelper(n-1, a, b, dp);
		dp.put(n,  ans);
		return ans;
		
	}
	
	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			HashMap<Integer,Integer> map = new HashMap<>();
			int min = Integer.MAX_VALUE;
			for(int i=0; i<(n*n); i++)
			{
				int x = sc.nextInt();
				min = Math.min(min, x);
				map.put(x,  map.getOrDefault(x, 0)+1);
			}
			
			if(bHelper(n, c, d, map, min))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			
			System.out.println();
			t --;
		}
	}
	
	private static boolean bHelper(int n, int c, int d, HashMap<Integer, Integer> map, int a11)
	{
		int a = a11;
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				if(i == 0 && j == 0)
				{
					if(map.containsKey(a) && map.get(a)!= 0)
					{
						map.put(a,  map.get(a)-1);
						continue;
					}
					else
					{
						return false;
					}
				}
				if( j == 0)
				{
					a = a11 + i*c;
					if(map.containsKey(a) && map.get(a)!= 0)
					{
						map.put(a,  map.get(a)-1);
						continue;
					}
					else
					{
						return false;
					}
				}
				
				int temp = a + j*d;
				if(map.containsKey(temp) && map.get(temp) != 0)
				{
					map.put(temp,  map.get(temp)-1);
				}
				else
				{
					return false;
				}
			}	
		}
		
		return true;
		
	}
	
	public static void main(String args[])
	{
		
	}
}

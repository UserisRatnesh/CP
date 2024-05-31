package Codeforces;

import java.util.PriorityQueue;
import java.util.Scanner;

public class EducationalRound_166_Div_2 
{
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			sc.nextLine();
			String s = sc.next();
			if(aHelper(n, s))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
		}
		sc.close();
	}
	
	private static boolean aHelper(int n, String s)
	{
		int prev = 0;
		for(int i=0; i<n; i++)
		{
			int ascii = s.charAt(i);
			if(ascii < prev)
			{
				return false;
			}
			prev = ascii;
		}
		return true;
	}
	
	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n+1];
			
			for(int i=0; i<n; i++)
			{
				a[i] = sc.nextInt();
			}
			for(int i=0; i<=n; i++)
			{
				b[i] = sc.nextInt();
			}
			
			System.out.println(bHelper(a, b, n));
		}
		sc.close();
	}
	
	private static long bHelper(int[] a, int[] b, int n)
	{
		int lastDigit = b[n];
		boolean isAppendNeedOperation = true;
		
		int minDiff = Integer.MAX_VALUE;
		
		long countOperations = 0;
		
		for(int i=0; i<n; i++)
		{
			int ai = a[i];
			int bi = b[i];
			if(lastDigit >= Math.min(ai, bi) && lastDigit <= Math.max(ai, bi)) 
			{
				isAppendNeedOperation = false;
			}
			else
			{
				// find the closest value to last Digit
				int diffAi = Math.abs(ai-lastDigit);
				int diffBi = Math.abs(bi-lastDigit);
				minDiff = Math.min(minDiff, Math.min(diffAi, diffBi));
				
			}
			countOperations += Math.abs(ai-bi);
		}
		
		// to append at last
		countOperations += 1;
		
		if(isAppendNeedOperation)
		{
			// to modify last
			countOperations += minDiff;
		}
		return countOperations;
	
	}
	
	
	private static void c()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n+m+1];
			int[] b = new int[n+m+1];
			
			for(int i=0; i<(n+m+1); i++)
			{
				a[i] = sc.nextInt();
			}
			for(int i=0; i<(n+m+1); i++)
			{
				b[i] = sc.nextInt();
			}
			
			cHelper(a, b, n, m, m+n+1);
			System.out.println();
		}
		sc.close();
	}
	
	
	private static void cHelper(int[] pgmr, int[] tstr, int pn, int tn, int n)
	{
		PriorityQueue<Integer> p = new PriorityQueue<>();
		PriorityQueue<Integer> t = new PriorityQueue<>();
		
		
		
		for(int i=0; i<n; i++)
		{
			int totalSkill = 0;
			int countP = 0;
			int countT = 0;
			
			for(int j=0; j<n; j++)
			{
				if(i == j)
				{
					continue;
				}
				
				// which skill is better
				int ps = pgmr[j];
				int ts = tstr[j];
				if(ps > ts && countP < pn)
				{
					countP++;
					p.add(ps);
					totalSkill += ps;
				}
				else if(countT < tn)
				{
					countT++;
					totalSkill += ts;
					t.add(ts);
				}
				else if(ps > ts)
				{
					int pop = p.size() > 0 ? p.peek() : Integer.MAX_VALUE;
					if(ps > pop)
					{
						totalSkill = totalSkill - pop + ps;
						p.poll();
						p.add(ps);
					}
				}
				else
				{
					int pop = t.size() > 0 ? t.peek() : Integer.MAX_VALUE;
					if(ts > pop)
					{
						totalSkill = totalSkill - pop + ts;
						t.poll();
						t.add(ts);
					}
				}
				
				
			}
			
			System.out.print(totalSkill +" ");
			
			p.clear();
			t.clear();
		}
	}
	
	

	public static void main(String[] args) 
	{
		
		c();
	}

}

package Codeforces;

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
			int np = sc.nextInt();
			int nt = sc.nextInt();

			int tc = np + nt + 1;

			int[] pSkill = new int[tc];
			int[] tSkill = new int[tc];

			for(int i=0; i<tc; i++)
			{
				pSkill[i] = sc.nextInt();
			}
			
			for(int i=0; i<tc; i++)
			{
				tSkill[i] = sc.nextInt();
			}
			
			
			int[] hiredProfile = new int[tc-1];
			// 0 = tester
			// 1 = programmer

			
			// iterate over pSkill and tSkill 
			// compare their skill and hire optimally
			// hire only first np + nt candidates
			
			long totalSkill = 0;
			int countPHired = 0;
			int countTHired = 0;
			
			// find the index of first un-optimal hired candidate 
			int firstUnoptimalHiringIndex = tc-1; // let say last one, which is not hired as of now
			
			// update whose hiring completed first
			int whoseHiringFirstCompleted = -1;
			
			
			// hire first n + m candidates if all were present
			for(int i=0; i<tc-1; i++)
			{
				int ps = pSkill[i];
				int ts = tSkill[i];
				
				// update whoseHiringCompletedFirst variable
				if(countPHired == np)
				{
					whoseHiringFirstCompleted = whoseHiringFirstCompleted == -1 ? 1 : whoseHiringFirstCompleted;
				}
				else if(countTHired == nt)
				{
					whoseHiringFirstCompleted = whoseHiringFirstCompleted == -1 ? 0 : whoseHiringFirstCompleted;
				}
				
				// Note = ps and ts can not be same as given is question
				
				if(ps > ts && countPHired < np) // optimal hiring
				{
					//hired as a programmer
					hiredProfile[i] = 1;
					totalSkill += ps;
					countPHired++;
				}
				
				else if(ts > ps && countTHired < nt) // optimal hiring
				{
					// hired as a tester
					hiredProfile[i] = 0;
					totalSkill += ts;
					countTHired++;
				}
				else if(countPHired < np) // un optimal hiring 
				{
					// hired as a programmer
					hiredProfile[i] = 1;
					totalSkill += ps;
					countPHired++;
					
					// if already updated then do not update it
					firstUnoptimalHiringIndex = firstUnoptimalHiringIndex == tc-1 ? i : firstUnoptimalHiringIndex;
				}
				else // un optimal hiring
				{
					// hired as a tester
					hiredProfile[i] = 0;
					totalSkill += ts;
					countTHired++;
					
					// if already updated then do not update it
					firstUnoptimalHiringIndex = firstUnoptimalHiringIndex == tc-1 ? i : firstUnoptimalHiringIndex;
				}
			}
			
			
			
			long ans = totalSkill; 
			
			// now iterate over m+n candidates
			// and find the total skill if they were not hired
			for(int i=0; i<tc-1; i++)
			{
				ans = totalSkill;
				
				// what if this candidate was absent
				
				
				// case one - if it was hired as a programmer
				if(hiredProfile[i] == 1)
				{
					// if hiring of programmer is completed first
					if(whoseHiringFirstCompleted == 1)
					{
						ans = ans - pSkill[i] + pSkill[firstUnoptimalHiringIndex] - tSkill[firstUnoptimalHiringIndex] + tSkill[tc-1];
						System.out.print(ans +" ");
							
					}
					
					// if hiring of tester completed first
					else
					{
						ans = ans - pSkill[i] + pSkill[tc-1];
						System.out.print(ans +" ");
					}
					
				}
				// case two -  if it was hired as a tester
				else
				{
					// if hiring of programmer is completed first
					if(whoseHiringFirstCompleted == 1)
					{
						
						ans = ans - tSkill[i] + tSkill[tc-1];
						System.out.print(ans+" ");
					}
					
					
					// if hiring of tester completed first
					else
					{
						ans = ans - tSkill[i] + tSkill[firstUnoptimalHiringIndex] - pSkill[firstUnoptimalHiringIndex] + pSkill[tc-1];
						System.out.print(ans +" ");
						
					}
				}	
			}
			System.out.println(totalSkill);

		}
		sc.close();
	}

	public static void main(String[] args) 
	{
		c();
	}

}

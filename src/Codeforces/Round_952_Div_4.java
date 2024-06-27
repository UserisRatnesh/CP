package Codeforces;


import java.util.HashSet;
import java.util.Scanner;

public class Round_952_Div_4
{
	
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t --> 0)
		{
			String a = sc.next();
			String b = sc.next();
			String newA = b.charAt(0) + a.substring(1);
			String newB = a.charAt(0) + b.substring(1);
			System.out.println(newA +" "+newB);

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
			if(n == 3)
			{
				System.out.println(3);
			}
			else
			{
				System.out.println(2);
			}

		}
		sc.close();
	}

	private static void c()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			Long[] arr = new Long[n];
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextLong();

			}

			long prefSum = 0;
			HashSet<Long> set = new HashSet<>();
			int ans = 0;

			for(int i=0; i<n; i++)
			{
				prefSum += arr[i];
				set.add(arr[i]);
				if(set.contains(prefSum/2) && prefSum %2 == 0)
				{
					ans++;
				}

			}	
			System.out.println(ans);

		}
		sc.close();
	}
	
	private static void cBetter()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int ans = 0;
			int maxTillNow = 0;
			long prefSum = 0;
			for(int i=0; i<n; i++)
			{
				int input = sc.nextInt();
				maxTillNow = Math.max(maxTillNow, input);
				prefSum += input;
				
				if(prefSum - maxTillNow == maxTillNow)
				{
					ans++;
				}
			}
			System.out.println(ans);

		}
		sc.close();
	}
	
	private static void d()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			Character[][] arr = new Character[n][m];
			sc.nextLine();	

			int maxHash = Integer.MIN_VALUE;
			int maxHashRow = -1;
			for(int i=0; i<n; i++)
			{
				int currCount = 0;
				String s = sc.nextLine();
				for(int j=0; j<m; j++)
				{
					char c = s.charAt(j);
					arr[i][j] = c;

					if(arr[i][j] == '#')
					{
						currCount++;
					}
				}

				if(currCount > maxHash)
				{
					maxHashRow = i;
					maxHash = Math.max(maxHash, currCount);
				}
			}

			// now we got the central row
			int startIndex = -1;
			int count  = 0;
			for(int i=0; i<m; i++)
			{
				if(arr[maxHashRow][i] == '#')
				{
					startIndex = startIndex == -1 ? i:startIndex;
					count++;
				}

			}

			int col = startIndex + (count/2);

			System.out.println((maxHashRow+1)+" "+(col+1));

		}
		sc.close();
	}

	private static void e()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
            long k = sc.nextLong();
            
            // a -> x
            // b -> y
            // c -> z  c = k/a*b
            long ans = 0;
            for(int a=1; a<=x; a++)
            {
            	for(int b=1; b<=y; b++)
            	{
            		long c = 2001;
            		if(k % (a*b) == 0)
            		{
            			c = k/(a*b);
            		}
            		
            		if(c <= z)
            		{
            			long tempAns = (x-a+1);
            			tempAns *= (y-b+1);
            			tempAns *= (z-c+1);
            			ans = Math.max(ans, tempAns);
            		}
            	}
            }
            System.out.println(ans);
		}
		sc.close();
	}
	

	public static void main(String[] args) 
	{
		e();
	}

}

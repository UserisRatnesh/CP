package Codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
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
            System.out.println(maxLocations(x, y, z, k));

		}
		sc.close();
	}
	
	private static List<int[]> countFactors(long k) {
        List<int[]> factors = new ArrayList<>();
        for (int a = 1; (long) a * a * a <= k; a++) {
            if (k % a == 0) {
                long ka = k / a;
                for (int b = a; (long) b * b <= ka; b++) {
                    if (ka % b == 0) {
                        int c = (int) (ka / b);
                        factors.add(new int[]{a, b, c});
                        if (a != b) factors.add(new int[]{a, c, b});
                        if (b != c) factors.add(new int[]{b, a, c});
                        if (c != a) factors.add(new int[]{b, c, a});
                        if (a != c) factors.add(new int[]{c, a, b});
                        if (b != a) factors.add(new int[]{c, b, a});
                    }
                }
            }
        }
        return factors;
    }

    private static int maxLocations(int x, int y, int z, long k) {
        int maxCount = 0;
        for (int[] dimensions : countFactors(k)) {
            int a = dimensions[0];
            int b = dimensions[1];
            int c = dimensions[2];
            if (a <= x && b <= y && c <= z) {
                maxCount = Math.max(maxCount, (x - a + 1) * (y - b + 1) * (z - c + 1));
            }
        }
        return maxCount;
    }

	

	public static void main(String[] args) 
	{
		e();
	}

}

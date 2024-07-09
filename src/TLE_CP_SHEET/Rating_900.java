package TLE_CP_SHEET;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



public class Rating_900 
{
	static class Pair 
	{
		int x, y;

		Pair(int x, int y) 
		{
			this.x = x;
			this.y = y;
		}

		// To store unique elements only
		public boolean equals(Object p) {
			if (this == p) return true;
			if (p == null || getClass() != p.getClass()) return false;
			Pair pair = (Pair) p;
			return x == pair.x && y == pair.y;
		}

		// To generate unique hash code
		public int hashCode() {
			return 31 * x + y;
		}


	}

	private static void A1904()
	{
		Scanner sc = new Scanner(System.in);
		int[] dx = {-1, -1, 1, 1};
		int[] dy = {-1, 1, -1, 1};

		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int xk = sc.nextInt();
			int yk = sc.nextInt();
			int xq = sc.nextInt();
			int yq = sc.nextInt();

			Set<Pair> king = new HashSet<>();
			Set<Pair> queen = new HashSet<>();

			for (int i = 0; i < 4; i++) {
				king.add(new Pair(xk + dx[i] * a, yk + dy[i] * b));
				king.add(new Pair(xk + dx[i] * b, yk + dy[i] * a));
				queen.add(new Pair(xq + dx[i] * a, yq + dy[i] * b));
				queen.add(new Pair(xq + dx[i] * b, yq + dy[i] * a));
			}

			int ans = 0;
			for (Pair p : king) {
				if (queen.contains(p)) {
					ans++;
				}
			}

			System.out.println(ans);
		}
		sc.close();
	}

	private static void B1883()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			String s = sc.next();
			HashMap<Character, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++)
			{
				char c = s.charAt(i);
				map.put(c, map.getOrDefault(c,0)+1);
			}
			
			int oddCount = 0;
			for(Map.Entry<Character, Integer> entry : map.entrySet())
			{
				int freq = entry.getValue();
				if((freq&1)== 1)
				{
					oddCount++;
				}
			}
			
			if(oddCount > k+1)
			{
				System.out.println("NO");
			}
			else
			{
				System.out.println("YES");
			}
			
		}
		sc.close();
	}

	private static void C1878()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) 
		{
			long n = sc.nextLong();
			long k = sc.nextLong();
			long x = sc.nextLong();
			
			long  minSum = k*(k+1)/2;
			long maxSum = n*(n+1)/2 - (n-k)*(n-k+1)/2;
			
			if(x >= minSum && x <= maxSum)
			{
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
			
		}
		sc.close();
	}
	
	
	private static void A1875()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) 
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int n = sc.nextInt();
			int arr[] = new int[n];
			long ans = b;
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextInt();
				b = Math.min(a, 1 + arr[i])-1;
				ans += b;
			}
			
			System.out.println(ans);
			
			
		}
		sc.close();
	}
	
	private static void A1869()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) 
		{
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextInt();
			}
			
			if ((n & 1) == 1) {
                System.out.println(4);
                System.out.println(1 + " " + 2);
                System.out.println(1 + " " + 2);
                System.out.println(2 + " " + n);
                System.out.println(2 + " " + n);
            } else {
                System.out.println(2);
                System.out.println(2 + " " + n);
                System.out.println(2 + " " + n);
            }
			
		}
		sc.close();
	}
	
	// Not correct 
	// Not submitted
	private static void B1855()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-->0)
		{
			long n = sc.nextLong();
			long smallestNonMultiple = 1;
			for(long i=1; i<=n; i++)
			{
				if(n % i != 0)
				{
					smallestNonMultiple = i;
					break;
				}
			}
			
			if(smallestNonMultiple == 1) System.out.println(1);
			else	System.out.println(smallestNonMultiple-1);
		}
		sc.close();
		
	}
	
	
	private static void D1850()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextInt();
			}
			int left = 0;
			int right = 0;
			int largestValidSequence = 1;
			Arrays.sort(arr);
			
			for(int i=1; i<n; i++)
			{
				if(arr[i] - arr[i-1] <= k)
				{
					right++;
				}
				else
				{
					largestValidSequence = Math.max(largestValidSequence, right-left+1);
					left = i;
					right = i;
				}
			}
			
			// check for last index also
			largestValidSequence = Math.max(largestValidSequence, right-left+1);
			
			System.out.println(n-largestValidSequence);
			
		}
		sc.close();
	}
	
	
	private static void B1833()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			String s = sc.next();
			int ans = 1;
			int count = 1;
			for(int i=1; i<n; i++)
			{
				if(s.charAt(i) == s.charAt(i-1))
				{
					count++;
				}
				else
				{
					count  = 1;
				}
				ans = Math.max(ans, count);
			}
			
			System.out.println(ans+1);
			
			
		}
		sc.close();
	}
	
	
	private static void D1807() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] prefSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                prefSum[i] = sc.nextInt() + prefSum[i - 1];
            }

            for (int i = 0; i < q; i++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                int k = sc.nextInt();
                int remove = prefSum[r] - prefSum[l - 1];
                int add = k * (r - l + 1);
                if ((prefSum[n] - remove + add) % 2 != 0) {
                    System.out.println("YES");
                } else
                    System.out.println("NO");
            }
        }
        sc.close();
    }
	
	private static void B1794() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int prev = sc.nextInt();
            if (prev == 1)
                prev++;
            System.out.print(prev + " ");
            for (int i = 1; i < n; i++) {
                int curr = sc.nextInt();
                if (curr == 1)
                    curr++;
                if (curr % prev == 0) {
                    curr++;
                }
                prev = curr;
                System.out.print(curr + " ");
            }
            System.out.println();
        }
        sc.close();
    }
	
	private static void A1726() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int ans = arr[n - 1] - arr[0];

            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, arr[i - 1] - arr[i]);
                if (i != n - 1) {
                    ans = Math.max(ans, arr[n - 1] - arr[i]);
                    ans = Math.max(ans, arr[i] - arr[0]);
                }
            }

            System.out.println(ans);
        }
        sc.close();
    }
	
	
	public static void B1696() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int ans = 0;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int input = sc.nextInt();
                if (input != 0) {
                    count++;
                    if (count == 1) {
                        ans++;
                    }
                } else {
                    count = 0;
                }
            }
            if (ans <= 1)
                System.out.println(ans);
            else
                System.out.println(2);
        }
        sc.close();
    }
	
	public static void A1679() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long n = sc.nextLong();
            long max = n / 4;
            long min = n / 6;
            if (n % 6 != 0) {
                min++;
            }
            if (n % 2 != 0 || n == 2) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
        sc.close();
    }
	
	
	public static void main(String[] args) 
	{
		B1833();

	}

}


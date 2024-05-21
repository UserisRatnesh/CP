package Codeforces;

import java.util.Scanner;
import java.util.HashMap;
import java.math.BigInteger;


class Pair<F,S>
{
	private F first;
	private S second;
	
	public Pair(F first, S second)
	{
		this.first=  first;
		this.second = second;
	}
	
	public F getFirst()
	{
		return this.first;
	}
	
	public S getSecond() 
	{
		return this.second;
	}
	
	public void setFirst(F first)
	{
		this.first = first;
	}
	
	public void setSecond(S second)
	{
		this.second = second;
	}
}

public class RandomQuestions 
{
	
	private static void maxiRect(char[][] arr)
	{
		int r = arr.length;
		int c = arr[0].length;
		
		int[][] ans = new int[r][c];
		
		ans[0][0] = arr[0][0] - '0';
		
		// filling first row
		for(int i=1; i<r; i++)
		{
			if(arr[i][0] == '0')
			{
				ans[i][0] = 0;
			}
			else
			{
				ans[i][0] = ans[i-1][0]+1;
			}
		}
		
		// filling first col
		for(int j=1; j<c; j++)
		{
			if(arr[0][j] == '0')
			{
				ans[0][j] = 0;
			}
			else
			{
				ans[0][j] = ans[0][j-1]+1;
			}
		}
		
		
		for(int i=1; i<r; i++)
		{
			for(int j=1; j<c; j++)
			{
				if(arr[i][j] == '0')
				{
					continue;
				}
				// iterate over row
				int row = i-1;
				int rowCount = 0;
				while(row >= 0)
				{
					if(arr[row][j] == '0')
					{
						break;
					}
					else
					{
						rowCount++;
						row--;
					}
				}
				
				int col = j-1;
				int colCount = 0;
				while(col >= 0)
				{
					if(arr[i][col] == '0')
					{
						break;
					}
					else
					{
						colCount ++;
						col--;
					}
				}
				
				int prevDia = ans[i-1][j-1];
				if(prevDia == 0 || rowCount == 0 || colCount == 0)
				{
					ans[i][j] = 1 + Math.max(colCount, rowCount);
				}
				else
				{
					
				}
			}
		}
	}
	
	private static void f()
	{
		Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Number of test cases
        scanner.nextLine(); // Consume newline
        while (t-- > 0) {
            String x = scanner.nextLine();
            String y = scanner.nextLine();

            StringBuilder newX = new StringBuilder(x);
            StringBuilder newY = new StringBuilder(y);

            int n = x.length(); // Length of the numbers

            // Iterate through the digits of x and y
            for (int i = 0; i < n; i++) {
                // If digit in x is greater than digit in y, swap them
                if (x.charAt(i) > y.charAt(i)) {
                    newY.setCharAt(i, x.charAt(i));
                }
                // If digit in x is smaller than digit in y and swapping increases product, swap them
                else if (x.charAt(i) < y.charAt(i) && newY.charAt(i) < y.charAt(i)) {
                    newX.setCharAt(i, y.charAt(i));
                    newY.setCharAt(i, x.charAt(i));
                }
                // If digit in x is smaller than digit in y but swapping decreases product, continue to the next digit
                else if (x.charAt(i) < y.charAt(i) && newY.charAt(i) >= y.charAt(i)) {
                    break;
                }
            }

            System.out.println(newX);
            System.out.println(newY);
        }

        scanner.close();
    }
	
	
	private static void c()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0)
		{
			String a = sc.nextLine();
			String b = sc.nextLine();
			BigInteger x = new BigInteger(a);
			BigInteger y = new BigInteger(b);
			BigInteger[] ans = new BigInteger[2];
			ans = cHelper(x, y, ans);
			System.out.println(ans[0]);
			System.out.println(ans[1]);
			t--;
		
		}
	}
	
	private static BigInteger[] cHelper(BigInteger x, BigInteger y, BigInteger[] ans)
	{
		
		
		int[] digitsX = toDigitsArray(x);
        int[] digitsY = toDigitsArray(y);
        
        
        BigInteger initialPro = x.multiply(y);
        
        for(int i=0; i<digitsX.length; i++)
        {
        	//swap 
        	int temp = digitsX[i];
        	digitsX[i] = digitsY[i];
        	digitsY[i] = temp;
        	BigInteger tempx = new BigInteger(digitsX.toString());
        	BigInteger tempy = new BigInteger(digitsY.toString());
        	BigInteger tempPro = tempx.multiply(tempy);
        	if(tempPro.compareTo(initialPro) > 0)
        	{
        		BigInteger[] tempans = new BigInteger[2];
        		tempans[0] = tempx;
        		tempans[1] = tempy;
        		return tempans;
        	}
        }
        
        return ans;
        
	}
	
	private static int[] toDigitsArray(BigInteger num) {
        String numString = num.toString();
        int[] digits = new int[numString.length()];
        for (int i = 0; i < numString.length(); i++) {
            digits[i] = numString.charAt(i) - '0';
        }
        return digits;
    }
	
	
	private static void b()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0)
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
	}
	
	
	private static int bHelper(int n, int[] arr)
	{
		 int start = 0;
		 int last = n-1;
		 
		 int removeFromBeg = 0;
		 while(start <n && arr[start] == arr[last])
		 {
			 removeFromBeg++;
			 start++;
		 }
		 
		 int removeFromEnd = 0;
		 start = 0;
		 while(last>=0 && arr[start] == arr[last])
		 {
			 removeFromEnd++;
			 last--;
		 }
		 
		 int minRemove = Math.min(removeFromBeg,removeFromEnd);
		 if(minRemove == n)
		 {
			 return -1;
		 }
		 return minRemove;

	}
	
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			if(cHelper(n, m, k))
			{
				System.out.println("YES");
			}
			else
			{
				System.out.println("NO");
			}
			t--;
		
		}
	}
	
	private static boolean cHelper(int n, int m, int k)
	{
		if(n == 1 || m == 1 || n == k)
		{
			return false;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int maxFreq = Integer.MIN_VALUE;
		
		int color = 1;
		for(int i=0; i<n; i++)
		{
			int updatedFreq = map.getOrDefault(color, 0)+1;
			map.put(color, updatedFreq);
			maxFreq = Math.max(maxFreq, updatedFreq);
			
			if(color == m)
			{
				color = 1;
			}
			else
			{
				color++;
			}
		}
		
		if((n-maxFreq) == k)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	
	private static void b1945()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			long a = sc.nextLong();
			long b = sc.nextLong();
			long m = sc.nextLong();
			helper1945b(a, b, m);
			t--;
		}
		
	}
	
	
	private static void helper1945b(long a, long b, long m)
	{
		long product = a*b;
		long last = product+m;
		long first = (last-product+a)/a;
		long second = (last-product+b)/b;
		System.out.println((first+second));
		
	}
	
	
	private static void c1941()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t != 0)
		{
			int n = sc.nextInt();
			String s = sc.next();
			System.out.println(helper1941c(n, s));;
			t--;
		}
	}
	
	private static int helper1941c(int n, String s)
	{
//		int ans = 0;
//		int i=0;
//		while(i<n)
//		{
//			if(s.indexOf("mapie", i) == i)
//			{
//				ans ++;
//				i = i+5;
//			}
//			else if(s.indexOf("map", i) == i || s.indexOf("pie", i) == i)
//			{
//				ans ++;
//				i = i+3;
//			}
//			else
//			{
//				i++;
//			}
//		}
//		
//		return ans;
		
		
		// below one accepted just because of startsWith method taking O(m) m->length of prefix we are checking for startWith
		// whereas indexOf takes O(n*m) n -> length of string
		int ans = 0;
        int i=0;
        while(i<n)
        {
            if (s.startsWith("mapie", i)) {
                ans++;
                i = i + 5; // move to the next position after "mapie"
            } else if ((s.startsWith("map", i) || s.startsWith("pie", i))) {
                ans++;
                i = i + 3; // move to the next position after "map" or "pie"
            }
            else
            {
            	i++;
            }
        }
        return ans;

	}

	private static void b1927()
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
		{
			arr[i] = scanner.nextInt();
		}

		HashMap<Character, Integer> hMap = new HashMap<>();
		int curr = 97;

		for (int i = 0; i < n; i++) 
		{
			if (arr[i] == 0) 
			{
				System.out.print((char) curr);
				hMap.put((char) curr, hMap.getOrDefault((char) curr, 0) + 1);
				curr++;
			} 
			else 
			{
				for (char key : hMap.keySet())
				{
					if (hMap.get(key) == arr[i]) 
					{
						System.out.print(key);
						hMap.put(key, hMap.get(key) + 1);
						break;
					}
				}
			}
		}
		System.out.println();
	}


	private static void c1954()
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
			String x = sc.nextLine();
			String y = sc.nextLine();
			
			c1954Helper(x, y);
		}
	}
	
	// product of two number is maximum if they are closest => only intuition
	// let initially n = EVEN 
	// => jab bhi alice choose karne aayega usko even number of up facing coins dikhega
	// isliye ek time aayega jab bob ke term ke time 1 rahega and bob wo choose karlega aur alice ke liye kuchh nahi bachega
	// ISKA just ulta hota hai when initially n = ODD
	private static void c1954Helper(String x, String y)
	{

		
		StringBuilder sx = new StringBuilder(x);
		StringBuilder sy = new StringBuilder(y);
		
		int l = sx.length();
		
		int index = 0;
		
		for(int i=0; i<l; i++)
		{
			char cx = sx.charAt(i);
			char cy = sy.charAt(i);
			if(cx < cy)
			{
				sx.setCharAt(i, cy);
				sy.setCharAt(i, cx);
				index = i+1;
				break;
			}
			else if(cx > cy)
			{
				index = i;
				break;
			}
		}
		
		for(int i=index+1; i<l; i++)
		{
			
			char cx = sx.charAt(i);
			char cy = sy.charAt(i);
			if(cx > cy)
			{
				sx.setCharAt(i, cy);
				sy.setCharAt(i, cx);
			}
		}
		
		System.out.println(sx);
		System.out.println(sy);

	}
	
	private static void aContestProposal()
	{
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t --> 0)
	    {
	        int n = sc.nextInt();
	        int[] a = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            a[i] = sc.nextInt();
	        }
	        int[] b = new int[n];
	        for(int i=0; i<n; i++)
	        {
	            b[i] = sc.nextInt();
	        }
	        
	        int maxShift = 0;
	        for(int i=0; i<n; i++)
	        {
	            int temp = 0;
	            for(int j=0; j<n; j++)
	            {
	                if(a[i] > b[j])
	                {
	                    temp ++;
	                }
	                else
	                {
	                    break;
	                }
	            }
	            
	            maxShift = Math.max(maxShift, temp);
	        }
	        System.out.println(maxShift);
	    }
	}
	
	
	private static void c1971()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			boolean cLies = false;
			boolean dLies = false;
			int min = Math.min(a, b);
			for(int i=min; i<=Math.max(a, b); i++)
			{
				if(i == c)
				{
					cLies = true;
				}
				if(i == d)
				{
					dLies = true;
				}
			}
			if((cLies && dLies) || (!cLies && !dLies))
			{
				System.out.println("No");
			}
			else
			{
				System.out.println("YES");
			}
		}
		sc.close();
	}
	
	private static void c1971_Another()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			// walk around the clock from 1 to 12
			// if any of the two red or blue comes first then not intersect else intersect
			// red -> a,b
			// blue -> c,d
			String s = "";
			for(int i=1; i<=12; i++)
			{
				if(i == a || i == b)
				{
					s += "r";
				}
				if(i == c || i == d)
				{
					s+= "b";
				}
			}
			
			if(s.equals("rbrb") || s.equals("brbr")) 
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
	
	private static void a1951()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			String s = sc.next();
			
			int one = 0;
			for(int i=0; i<n; i++)
			{
				if("1".equals(s.charAt(i)+""))
				{
					one++;
				}
			}
			
			if(one % 2 == 0)
			{
				if(one == 2)
				{
					// check adjacent or not
					int i = s.indexOf("1");
					int j = s.lastIndexOf("1");
					if(i+1 == j)
					{
						System.out.println("NO");
					}
					else
					{
						System.out.println("YES");
					}
				}
				else
				{
					System.out.println("YES");
				}
			}
			else
			{
				System.out.println("NO");
			}
		}
		sc.close();
	}
	
	
	private static void c1921()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t --> 0)
		{
			int n = sc.nextInt();
			long f = sc.nextLong();
			long a = sc.nextLong();
			long b = sc.nextLong();
			long[] arr = new long[n];
			
			int prev = -1;
			for(int i=0; i<n; i++)
			{
				arr[i] = sc.nextLong();
				if(prev == -1)
				{
					
					Long on = (arr[i] - 0)*a;
					if(on < b)
					{
						f -= on ;
					}
					else
					{
						f -= b;
					}
				}
				else
				{
					Long on = (arr[i] - arr[prev])*a;
					if(on < b)
					{
						f -= on;
					}
					else
					{
						f -= b;
					}
				}
				prev = i;
			}
			
			if(f <= 0)
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
	
	
	public static void main(String[] args) 
	{
		
		c1921();
	}

}

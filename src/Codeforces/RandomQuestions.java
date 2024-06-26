package Codeforces;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.math.BigInteger;

// first make F comparable then use it to compare
class Pair<F extends Comparable<F> ,S> implements Comparable<Pair<F, S>>
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
	
	public int compareTo(Pair<F, S> other)
	{
		return this.first.compareTo(other.first);
	}
}

class Triple<F extends Comparable<F> , S extends Comparable<S>, T> implements Comparable<Triple<F, S, T>>
{
	private F first;
	private S second;
	private T third;
	
	
	public Triple(F first, S second, T third)
	{
		this.first=  first;
		this.second = second;
		this.third  = third;
	}
	
	public F getFirst()
	{
		return this.first;
	}
	
	public S getSecond() 
	{
		return this.second;
	}
	
	public T getThird()
	{
		return this.third;
	}
	
	public void setFirst(F first)
	{
		this.first = first;
	}
	
	public void setSecond(S second)
	{
		this.second = second;
	}
	
	public void setThird(T third)
	{
		this.third = third;
	}
	
	public int compareTo(Triple<F, S, T> other)
	{
		int ans = this.first.compareTo(other.first);
		if(ans == 0)
		{
			ans = other.second.compareTo(this.second);
		}
		return ans;
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
					f -= Math.min(a*arr[i], b);
				}
				else
				{
					f -= Math.min(a*(arr[i]-arr[i-1]), b);
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
	
	
	private static void b1918()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- >0)
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
            
            mergeSort(a, b, 0,n-1);
            
            for(int i=0; i<n; i++)
            {
            	System.out.print(a[i]+" ");
            }
            System.out.println();
            for(int i=0; i<n; i++)
            {
            	System.out.print(b[i]+" ");
            }
            System.out.println();
            
            
        }
        sc.close();
    }
    
	private static void b1918_2nd()
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- >0)
        {
            int n = sc.nextInt();
            Pair<Integer, Integer>[] ab = new Pair[n];
            
            for(int i=0; i<n; i++)
            {
            	ab[i] = new Pair<>(0, 0);
            	ab[i].setFirst(sc.nextInt());
            }
            for(int i=0; i<n; i++)
            {
            	ab[i].setSecond(sc.nextInt());
            }
            
            Arrays.sort(ab);
            
            for(int i=0; i<n; i++)
            {
            	System.out.print(ab[i].getFirst()+" ");
            }
            System.out.println();
            for(int i=0; i<n; i++)
            {
            	System.out.print(ab[i].getSecond()+" ");
            }
            System.out.println();
            	
            
        }
        sc.close();
	}
	
    private static int mergeSort(int [] a,int[] b, int si, int li)
    {
    	if(si == li)
    	{
    		return 0 ;
    	}
    	
        int mid = (si+li)/2;
        
        int count = 0;
        
        count += mergeSort(a, b, mid+1, li);
        count += mergeSort(a, b, si, mid);
        
        count += merge(a, b, si, li, mid);
        
        return count;
    }
    
    private static int merge(int[] a,int[] b, int si, int li, int mid)
    {
    	int n = li-si+1;
    	int count = 0;
    	
    	int index = 0;
    	int[] list = new int[n];
    	int[] listb = new int[n];
    	int indexb = 0;
    	int left = si;
    	int right = mid + 1;
    	while(left <= mid && right <=li)
    	{
    		if(a[left] <= a[right])
    		{
    			list[index++] = a[left];
    			listb[indexb++] = b[left];
    			left++;
    			
    		}
    		else
    		{
    			list[index++] = a[right];
    			listb[indexb++] = b[right];
    			right++;
    			count += (mid-left+1);
    		}
    	}
    	
    	while(left <= mid)
    	{
    		list[index++] = a[left];
    		listb[indexb++] = b[left];
    		left++;
    	}
    	
    	while(right <= li)
    	{
    		list[index++] = a[right];
    		listb[indexb++] = b[right];
    		right++;
    	}
    	
    	for(int i=si; i<=li; i++)
    	{
    		a[i] = list[i-si];
    		b[i] = listb[i-si];
    	} 
    	
    	return count;
    }
    
    
    
    // Not done yet
    private static void D1971()
    {
    	Scanner sc = new Scanner(System.in);
    	int t = sc.nextInt();
    	while(t --> 0)
    	{
    		String s = sc.next();
    		int n = s.length();
    		
    		int cut = 0;
    		boolean first0To1 = false;
    		for(int i=0; i<n-1; i++)
    		{
    			// count transition from 1 to 0, since it will require cut
    			if(s.charAt(i) == '1' && s.charAt(i+1) == '0')
    			{
    				cut++;
    			}
    			else if(s.charAt(i) == '0' && s.charAt(i+1) == '1')
    			{
    				if(!first0To1)
    				{
    					first0To1 = true;
    				}
    				else 
    				{
    					cut++;
    				}
    			}
    		}
    		System.out.println(cut+1);
    		
    	}
    	sc.close();
    }
    
	
    private static void A1_1970()
    {
    	Scanner sc = new Scanner(System.in);
    	String s = sc.next();
    	int n = s.length();
    	List<Triple<Integer, Integer, Character>> list = new ArrayList<>();

        int prefixSum = 0;
        for (int i = 0; i < n; i++) 
        {
            char c = s.charAt(i);
            list.add(new Triple<>(prefixSum, i, c));
            if (c == '(') {
                prefixSum++;
            } else {
                prefixSum--;
            }
        }

        Collections.sort(list);

        StringBuilder ans = new StringBuilder();
        for (Triple<Integer, Integer, Character> triple : list) {
            ans.append(triple.getThird());
        }

        System.out.println(ans.toString());

    	
    	sc.close();
    }
    
    
	public static void main(String[] args) 
	{
		
		A1_1970();
	}

}

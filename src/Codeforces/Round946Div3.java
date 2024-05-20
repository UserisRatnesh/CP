package Codeforces;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Round946Div3 
{

	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			double numberOf1by1 = sc.nextInt();
			double numberOf2by2 = sc.nextInt();
			
			double minNumberOfSc = Math.ceil(numberOf2by2/2);
			double numberOf1by1Available = minNumberOfSc*15 - 4*numberOf2by2;
			if(numberOf1by1Available < numberOf1by1)
			{
				minNumberOfSc += Math.ceil((numberOf1by1 - numberOf1by1Available)/15.0);
			}
			
			System.out.println(minNumberOfSc);
			
		}
		sc.close();
	}
	
	private static void b() {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String encoded = sc.next();
            char[] arr = encoded.toCharArray();
            Arrays.sort(arr);
 
            // Remove duplicate characters and build resulting string
            StringBuilder r = new StringBuilder();
            r.append(arr[0]);
            for (int i = 1; i < n; i++) {
                if (arr[i] != arr[i - 1]) {
                    r.append(arr[i]);
                }
            }
 
            // Build resulting string
            StringBuilder s = new StringBuilder();
            int li = r.length() - 1;
            for (int i = 0; i < n; i++) {
                char c = encoded.charAt(i);
                int index = r.indexOf(String.valueOf(c));
                int indexToAdd = li - index;
                s.append(r.charAt(indexToAdd));
            }
            System.out.println(s);
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
        	int[] arr = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		arr[i] = sc.nextInt();
        	}
        	
        	List<List<Integer>> triples = new ArrayList<>();
        	
        	List<Integer> triple = new ArrayList<>();
        	triple.add(arr[0]);
        	triple.add(arr[1]);
        	triple.add(arr[2]);
        	triples.add(triple);
        	
        	int ans = 0;
        	
        	for(int i=1; i<n-2; i++)
        	{
        		int a = arr[i];
        		int b = arr[i+1];
        		int c = arr[i+2];
        		for(List<Integer> list : triples)
        		{
        			int equalCount = 0;
        			
        			for(int index=0; index<3; index++)
        			{
        				if(list.get(index) == arr[i+index])
        				{
        					equalCount++;
        				}
        			}
        			if(equalCount == 2)
        			{
        				ans++;
        			}
        		}
        		
        		List<Integer> list = new ArrayList<>();
        		list.add(a);
        		list.add(b);
        		list.add(c);
        		triples.add(list);
        	}
        	
        	System.out.println(ans);
        	
        }
        sc.close();
	}
	
	private static void d()
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- >0)
        {
        	int n = sc.nextInt();
        	String s = sc.next();
        	
        }
        sc.close();
	}
	
	
	public static void main(String[] args) 
	{
		d();

	}

}

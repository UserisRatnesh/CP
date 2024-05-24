package Codeforces;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        	
        	HashMap<List<Integer>, List<Integer>> triples = new HashMap<>();
        	int ans = 0;
        	
        	for(int i=0; i<3; i++)
        	{
        		
        		// count all beautiful pairs having i th element different
        		for(int j=0; j<n-2; j++)
            	{
            		List<Integer> triple = new ArrayList<>();
            		triple.add(arr[j]);
            		triple.add(arr[j+1]);
            		triple.add(arr[j+2]);
            		int ithElement = triple.get(i);
            		triple.remove(i);
            		List<Integer> value = triples.getOrDefault(triple, new ArrayList<>());
            		value.add(ithElement);
        			triples.put(triple, value);
            	}
        		
        		// iterate over the each entry of map
        		for(Map.Entry<List<Integer>, List<Integer>> entry : triples.entrySet())
        		{
        			List<Integer> list = entry.getValue();
        			List<Integer> tempList = new ArrayList<>();
        			
        			int count = 1;
        			Collections.sort(list);
        			for(int j=1; j<list.size(); j++)
        			{
        				if(list.get(j).equals(list.get(j-1)))
        				{
        					count++;
        				}
        				else
        				{
        					tempList.add(count);
        					count = 1;
        				}
        			}
        			
        			tempList.add(count);
        			if(tempList.size() < 2)
        			{
        				continue;
        			}
        			int sum = 0;
        			for(Integer x : tempList)
        			{
        				sum += x;
        			}
        			
        			sum = sum*(sum-1)/2;
        			ans += sum;
        			for(Integer x : tempList)
        			{
        				ans -= (x*(x-1)/2);
        			}
        			
        			
        		}
        		
        		triples.clear();
        	}
        	
        	System.out.println(ans);
        }
        sc.close();
	}
	
	
	
	public static void main(String[] args) 
	{
		c();

	}

}

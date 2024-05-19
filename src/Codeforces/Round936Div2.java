package Codeforces;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Round936Div2 
{
	public static int leastInterval(char[] tasks, int n) 
    {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = tasks.length;
        for(int i=0; i<l; i++)
        {
            char key = tasks[i];
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        int ans = 0;
        int count = 0;
        
        while(true)
        {
            if(count <= n && count != 0)
            {
                count++;
                ans++;
            }
            else
            {
                count = 0;
                Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
                while(iterator.hasNext())
                {
                    Map.Entry<Character, Integer> entry = iterator.next();
                    int freq = entry.getValue();
                    if(freq == 1)
                    {
                        iterator.remove(); // Use iterator to safely remove the entry
                    }
                    else
                    {
                        entry.setValue(freq - 1);
                    }
                    count++;
                    ans++;
                }
                if(map.isEmpty())
                {
                    break;
                }
            }
        }

        return ans;
    }
	
	public static int leastInterval1(char[] tasks, int n) 
    {
        Integer[] freq = new Integer[26];
        int l = tasks.length;
        for(int i=0; i<l; i++)
        {
            char c = tasks[i];
            int index = c-65;
//            freq[index] = freq[index]+1;
        }
        int ans = 0;
        
//        Arrays.sort(freq, Collections.reverseOrder());
        
        
        
        return ans;
    }
	
	
	public static void main(String args[])
	{
		char[] task = {'a','a','a','b','b','b'};
		int n = 3;
		System.out.println(leastInterval1(task, n));
	}

}

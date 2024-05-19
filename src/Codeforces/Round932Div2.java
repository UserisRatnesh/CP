package Codeforces;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;;

public class Round932Div2 {
	
	
	// giving tle
	private static ArrayList<ArrayList<Integer>> getAns(ArrayList<Integer> list)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = list.size();
        ArrayList<Integer> prefMex = new ArrayList<>();
        int[] sufMex = new int[n];
        
        
        HashSet<Integer> preMexSet = new HashSet<>();
        int a = 0;
        for (int i = 0; i < n; i++) {
            preMexSet.add(list.get(i));
            while (preMexSet.contains(a)) {
                a++;
            }
            prefMex.add(a);
        }

        HashSet<Integer> sufMexSet = new HashSet<>();
        int b = 0;
        for (int i = n - 1; i >= 0; i--) {
            sufMexSet.add(list.get(i));
            while (sufMexSet.contains(b)) {
                b++;
            }
            sufMex[i] = b;
        }

        
        for(int i=0; i<n-1; i++)
        {
            if(prefMex.get(i).equals(sufMex[i+1]))
            {
                ArrayList<Integer> one = new ArrayList<>();
                one.add(1);
                one.add(i+1);
                ArrayList<Integer> two = new ArrayList<>();
                two.add(i+2);
                two.add(n);
                ans.add(one);
                ans.add(two);
                return ans;
            }
        }
        
        return null;
        
    }
    
	
	private static String B1927(int[] a, int n)
	{
		//TLE
		char[] ans = new char[n];
		char c = 'a';
		int l = 0;
		while(l != n)
		{
			int count = 0;
			for(int i=0; i<n; i++ )
			{
				if(a[i] == count)
				{
					ans[i] = c;
					count++;
					l++;
				}
			}
			c = (char)(c+1);
		}
		
		return new String(ans);
		
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0)
        {
            int n = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i=0; i<n; i++)
            {
                list.add(sc.nextInt());
            }
            
            ArrayList<ArrayList<Integer>> ans = getAns(list);
            if(ans == null)
            {
                System.out.println(-1);
            }
            else
            {
                System.out.println(2);
                for(ArrayList<Integer> l : ans)
                {
                    System.out.println(l.get(0)+" "+l.get(1));
                }
            }
		    t--;
        }

        sc.close();
	}

}
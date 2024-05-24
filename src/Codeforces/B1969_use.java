package Codeforces;

import java.util.Scanner;

public class B1969_use 
{

	public static void main(String[] args) 
	{
		f();

	}
	
	private static void f()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String s = sc.next();
            int t1 = -1;
            int ans = 0;
            
            StringBuilder sb = new StringBuilder(s);
            for(int i=0; i<sb.length()-1; i++)
            {
                char c = sb.charAt(i);
                if(c == '1' && t1 == -1)
                {
                    t1 = i;
                }
                
                // 1 To 0 transition
                if(c == '1' && sb.charAt(i+1) == '0')
                {
                    ans += (i+1) - t1 + 1;
                    sb.setCharAt(i+1, '1');
                    sb.setCharAt(t1, '0');
                    t1 = t1+1;
                }
            }
            
            System.out.println(ans);
        }
    }

}

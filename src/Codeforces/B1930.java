package Codeforces;

import java.util.Scanner;

public class B1930
{
    private static void f()
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t --> 0)
        {
            int n = sc.nextInt();
            
            int l = 1;
            int r = n;
            boolean left = true;
            for(int i=0; i<n; i++)
            {
                if(left)
                {
                    System.out.print(l +" ");
                    l++;
                }
                else{
                    System.out.print(r+" ");
                    r--;
                }
                left = !left;
            }
            
            System.out.println();
        }
        sc.close();
    }
    
    public static void main(String[] args)
    {
        f();
        
    }
}
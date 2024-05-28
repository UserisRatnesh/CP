package Codeforces;


import java.util.Scanner;
public class B1941_use 
{
	private static void B1941()
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
			
			if(helper(a, n))
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
	
	private static boolean helper(int[] a, int n) {
        for (int i = 0; i < n - 2; i++) {
            if (a[i] < 0) return false;
            int operations = a[i];
            a[i] -= operations;
            a[i + 1] -= 2 * operations;
            a[i + 2] -= operations;
        }
        
        // After the loop, check the last two elements
        return a[n - 1] == 0 && a[n - 2] == 0;
    }

	public static void main(String[] args) 
	{
		B1941();
	}

}

package Codeforces;

import java.util.Scanner;

public class Round_949_Div_2 
{
	
	private static void a()
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t--> 0)
		{
			int l = sc.nextInt();
			int r = sc.nextInt();
			
			System.out.println(maximumScore(l,r));
		}
		sc.close();
	}
	
	public static int maximumScore(int l, int r) {
        // We can choose the maximum value of x such that x is a power of 2 and within the range [l, r]
        int maxX = Integer.highestOneBit(r);
        if (maxX < l) {
            maxX = l;
        }
        
        // The maximum score is the number of times we can divide maxX by 2
        int score = 0;
        while (maxX > 1) {
            maxX /= 2;
            score++;
        }
        
        return score;
    }
	

	public static void main(String[] args) 
	{
		
	}

}

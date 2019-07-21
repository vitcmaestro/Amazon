//https://practice.geeksforgeeks.org/problems/dice-throw/0

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static long findways(int m,int n,int sum)
    {
        long[][] dp = new long[n+1][sum+1];
        for(int j=1;j<=sum && j<=m ;j++)
        dp[1][j] = 1;
        for(int i=1;i<=n;i++)
        {
            for(int j =1;j<=sum;j++)
            {
                for(int k=1;k<=m && k<j;k++)
                {
                    dp[i][j]+=dp[i-1][j-k];
                }
            }
        }
        return dp[n][sum];
    }
	public static void main (String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
		{
		    int T =Integer.parseInt(br.readLine());
		    int[] arr;
		    for(int i =0;i<T;i++)
		    {
		        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		        System.out.println(findways(arr[0],arr[1],arr[2]));
		    }
		}
		catch(Exception e)
		{
		    System.out.println(e);
		}
	}
}

import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

public class Main {
	static int N;
	static ArrayList<Integer>[] triangle;
	static ArrayList<Integer>[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		triangle = new ArrayList[N];
		dp = new ArrayList[N];
		for(int i=0;i<N;i++) {
			triangle[i] = new ArrayList<>();
			dp[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<=i;j++) {
				triangle[i].add(Integer.parseInt(st.nextToken()));
				dp[i].add(0);
			}
		}
        
		dp[0].set(0, triangle[0].get(0));
		int res =dp[0].get(0);
		for(int i=1;i<N;i++) {
			for(int j=0; j<=i;j++) {
				if(j==0) 
					dp[i].set(j, triangle[i].get(j)+dp[i-1].get(j));
				else if (j==i) 
					dp[i].set(j, triangle[i].get(j)+dp[i-1].get(j-1));
				else 
					dp[i].set(j, triangle[i].get(j)+Math.max(dp[i-1].get(j),dp[i-1].get(j-1)));
				res = Math.max(res, dp[i].get(j));
			}
		}	
		System.out.println(res);
	}
}
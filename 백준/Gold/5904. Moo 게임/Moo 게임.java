import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		
		long[] S = makeS(60);
		
		System.out.println(dq(S,N));
		
	}
	
	public static long[] makeS(int len) {
		long dp[] = new long[len+1];
		dp[0] = 3;
		
		for(int i=1;i<=len;i++) {
			dp[i] = 2*dp[i-1]+i+3;
		}
		
		return dp;
	}
	
	public static char dq(long[] s, long N) {
		
		if(N==1) return 'm';
		else if(N==2||N==3) return 'o';
		
		for(int i=0;i<s.length-1;i++) {
			if(s[i]<N && N<=s[i]+i+4) {
				if(N==s[i]+1) return 'm';
				else return 'o';
			}
			else if(s[i]+i+4<N && N<=s[i+1]) {
				return dq(s, N-s[i]-i-4);
			}
		}
		
		return 'x';
	}
	
}

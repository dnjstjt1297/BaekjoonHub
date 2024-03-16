import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.MathContext;

public class Main {
	static int[] dx = {1,-1};
	static int T;
	static int n;
	static int[][] arr;
	static int res;
	static ArrayList<Integer> resList;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		resList = new ArrayList<>();
		for(int i=0;i<T;i++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[2][n];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[0][j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[1][j] = Integer.parseInt(st.nextToken());
			}
			findMax();
			resList.add(res);
		}
		for(int e: resList) {
			System.out.println(e);
		}
	}
	public static void findMax() {
		res = 0;
		int[][] dp = new int[2][n];
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		if(n>1) {
			dp[0][1] = arr[0][1]+arr[1][0];	
			dp[1][1] = arr[0][0]+arr[1][1];
		}
		for(int i=2; i<n;i++) {
			
			dp[0][i] = Math.max(dp[0][i-2]+arr[1][i-1]+arr[0][i],dp[0][i]);
			dp[0][i] = Math.max(dp[1][i-2]+arr[0][i],dp[0][i]);
			dp[0][i] = Math.max(dp[1][i-1]+arr[0][i],dp[0][i]);
			
			dp[1][i] = Math.max(dp[1][i-2]+arr[0][i-1]+arr[1][i],dp[1][i]);
			dp[1][i] = Math.max(dp[0][i-2]+arr[1][i],dp[1][i]);
			dp[1][i] = Math.max(dp[0][i-1]+arr[1][i],dp[1][i]);

		}
		for(int[] e: dp) {
			for(int f : e) {
				res = Math.max(res,f);
			}
		}
	}
}

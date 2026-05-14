
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main (String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dts = new int[n][2];
			
			for(int i = 0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				dts[i][0] = Integer.parseInt(st.nextToken());
				dts[i][1] = Integer.parseInt(st.nextToken());
				
			}
			
			Arrays.sort(dts, (o1,o2)->{
				return o1[1]-o2[1];
			});
			
			int tmp = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++) {
				min = Math.min(min,dts[i][1]-dts[i][0]-tmp);
				tmp+=dts[i][0];
			}
			System.out.println(min);
		}
	}
}

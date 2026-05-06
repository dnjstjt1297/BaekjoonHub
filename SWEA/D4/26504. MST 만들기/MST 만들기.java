

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
			int m = (n*(n-1))/2;
			int[] cs = new int[m];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i<m ;i++) {
				cs[i] = Integer.parseInt(st.nextToken());
			}
			
			
			Arrays.sort(cs);
			
			long min = 0;
			long max = 0;
			for(int i = 0; i<n-1; i++) {
				min+=cs[i];
			}
			
			int cnt = 0;
			int idx = m-1;
            int tmp = n-2;
			while(tmp>0){
            	for(int i = idx; i>idx-tmp; i--){
                	cs[i] = 0;
                }
                tmp--;
                idx=idx-tmp-2;
            }
            
            for(int i = 0; i<m; i++) {
				max+=cs[i];
			}
            
			System.out.println(min+" "+max);
		}
	}
}

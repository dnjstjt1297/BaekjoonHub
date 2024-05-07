import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			long answer =0;
			int N = sc.nextInt();

			int[] prices = new int[N];
			for(int i=0;i<N;i++) {
				prices[i] = sc.nextInt();
			}
			
			int start =0;
			while(true) {
				if(start >=N) break;
				long maxPrice = 0;
				int maxPriceIdx = -1;
				
				for(int i=start;i<N;i++) {
					if(maxPrice<=prices[i]) {
						maxPrice = prices[i];
						maxPriceIdx = i;
					}
				}
				
				long getItems = maxPriceIdx-start;
				
				long purc = 0;
				
				for(int i=start; i<maxPriceIdx;i++) {
					purc += prices[i];
				}
				
				answer+=maxPrice*getItems-purc;
				
				start = maxPriceIdx+1;
			}
			System.out.println("#"+test_case+" "+answer);
		}
	}
}
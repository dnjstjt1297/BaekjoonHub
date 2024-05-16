
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N =sc.nextInt();
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = sc.nextInt();
			}
			int max = -1;
			int mul;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					mul = arr[i]*arr[j];
					int tmp = mul;
					int prev = tmp%10;
					tmp /=10;
					boolean is_increate = true;
					while(tmp>0) {
						if(prev-1==tmp%10) {
							prev = tmp%10;
							tmp /=10;
						}
						else {
							is_increate = false;
							break;
						}
					}
					if(is_increate) {
						max = Math.max(max,mul);
					}
				}
			}
			
			System.out.println("#"+test_case+" "+max);
			
		}
	}
	
}

import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			long answer =0;
			String madi = sc.next();
			
			
			String str="";
			for(int i=1;i<madi.length();i++) {
				String left = madi.substring(0,i/2);
				String right = madi.substring(i/2,i);
				if(left.equals(right)) {
					str = left;
					break;
				}
			}
			
			System.out.println("#"+test_case+" "+str.length());
		}
	}
}
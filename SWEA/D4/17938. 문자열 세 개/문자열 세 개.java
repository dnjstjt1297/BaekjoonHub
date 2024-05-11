import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int Z = sc.nextInt();
			
			String A = "";
			String B = "";
			String C = "";
			
			if(X<=Y&&X<=Z) {
				for(int i=0;i<X;i++) {
					A+="0";
					B+="0";
					C+="0";
				}
				
				for(int i=0;i<Y-X;i++) {
					B+="1";
					C+="1";
				}
				for(int i=0;i<Z-X;i++) {
					A="1"+A;
					C="1"+C;
				}
			}
			else if(Y<=Z) {
				for(int i=0;i<Y;i++) {
					A+="0";
					B+="0";
					C+="0";
				}
				
				for(int i=0;i<X-Y;i++) {
					A+="1";
					B+="1";
				}
				for(int i=0;i<Z-Y;i++) {
					A="1"+A;
					C="1"+C;
				}
				
			}
			else {
				for(int i=0;i<Z;i++) {
					A+="0";
					B+="0";
					C+="0";
				}
				
				for(int i=0;i<X-Z;i++) {
					A+="1";
					B+="1";
				}
				for(int i=0;i<Y-Z;i++) {
					B="1"+B;
					C="1"+C;
				}
			}
			
		
			System.out.println("#"+test_case+" "+A+" "+B+" "+C);
		}
		
	}
	
	
}
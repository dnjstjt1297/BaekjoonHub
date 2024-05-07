import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	
	static boolean[] is_prime;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			String[] A = new String[n];
			
			for(int i=0;i<n;i++) {
				A[i] = sc.next();
			}
			
			
			boolean is_odd_black = false;
			for(int i =0;i<n;i++) {
				for(int j=0; j<m;j++) {
					if(A[i].charAt(j)=='#') {
						if((i+j)%2==1) is_odd_black = true;
						break;
					}
					else if(A[i].charAt(j)=='.') {
						if((i+j)%2==0) is_odd_black = true;
						break;
					}
				}
			}
			
			boolean is_possible = true;
			for(int i =0;i<n;i++) {
				for(int j=0; j<m;j++) {
					if((i+j)%2==1) {
						if(is_odd_black) {
							if(A[i].charAt(j)=='.') {
								is_possible = false;
							}
						}
						else {
							if(A[i].charAt(j)=='#') {
								is_possible = false;
							}
						}	
					}
					else {
						if(is_odd_black) {
							if(A[i].charAt(j)=='#') {
								is_possible = false;
							}
						}
						else {
							if(A[i].charAt(j)=='.') {
								is_possible = false;
							}
						}
					}
				}
			}
			
			if(is_possible)
				System.out.println("#"+test_case+" possible");
			else
				System.out.println("#"+test_case+" impossible");
		}
	}
}


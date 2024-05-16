
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
			String N = sc.next();
			
			int two = N.charAt(2)-'0';
			int one = N.charAt(1)-'0';
			int Int = N.charAt(0)-'0';
			int pow = N.length()-1;
			if(two>=5) {
				one+=1;
				if(one == 10) {
					Int+=1;
					one=0;
					if(Int == 10) {
						Int = 1;
						pow+=1;
					}
				}
			}
			System.out.println("#"+test_case+" "+Int+"."+one+"*10^"+pow);
		}
	}
	
}

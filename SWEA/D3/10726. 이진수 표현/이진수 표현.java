
import java.util.Scanner;
import java.io.FileInputStream;

class Location {
	char type;
	int idx;
	public Location(char type, int idx) {
		this.type = type;
		this.idx = idx;
	}
	
}

class Solution {
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int tmp = 1;
			tmp=tmp<<N;
			tmp-=1;
			boolean is_answer = false;
			if((tmp&M)==tmp) {
				is_answer = true;
			}
			if(is_answer)
				System.out.println("#"+test_case+" ON");
			else
				System.out.println("#"+test_case+" OFF");
		}
	}
	
}

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	
	static boolean[] is_prime;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int answer =0;
		for(int i=1;i<=T;i++) {
			answer+=i;
		}
		System.out.println(answer);
	}
}


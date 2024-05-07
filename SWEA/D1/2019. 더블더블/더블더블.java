import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	
	static boolean[] is_prime;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long num = 1;
		System.out.print(1+" ");
		for(int i=1;i<=n;i++) {
			num *=2;
			System.out.print(num+" ");
		}
	}
}


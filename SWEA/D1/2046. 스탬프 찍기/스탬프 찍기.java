import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	
	static boolean[] is_prime;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String answer = "";
		for(int i=0; i<N;i++)
			answer+='#';
		System.out.println(answer);
	}
}


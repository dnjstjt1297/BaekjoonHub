import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	
	static boolean[] is_prime;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		if((A==3&&B==2)||(A==2&&B==1)||(A==1&&B==3)) {
			System.out.println("A");
		}
		if((B==3&&A==2)||(B==2&&A==1)||(B==1&&A==3)) {
			System.out.println("B");
		}
	}
}


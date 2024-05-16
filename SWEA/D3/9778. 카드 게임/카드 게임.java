
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
			int[] cards = new int[12];
			for(int i=2;i<=9;i++) {
				cards[i] = 4;
			}
			cards[11] = 4;
			cards[10] = 16;
			
			int score = 0;
			for(int i=0;i<N;i++) {
				int c = sc.nextInt();
				score+=c;
				cards[c] --;
			}
			int numA = 0;
			int numB = 0;
			for(int i=2;i<=11;i++) {
				if(score+i>21) {
					numA+=cards[i];
				}
				else {
					numB+=cards[i];
				}
			}
			if(numA>=numB) {
				System.out.println("#"+test_case+" STOP");
			}
			else {
				System.out.println("#"+test_case+" GAZUA");
			}
			
			
		}
	}
	
	
}

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
	static int answer1 = Integer.MAX_VALUE;
    static ArrayList<Long> answer2;
    static Stack<Long> st = new Stack<>();
    static boolean is_exit = false;
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int box1 = sc.nextInt();
			int box2 = sc.nextInt();
			int box3 = sc.nextInt();
			
			int answer = 0;
			
			if(box2==1||box3<=2) {
				System.out.println("#"+test_case+" "+-1);
				continue;
			}
			
			if(box2>=box3) {
				answer+=(box2-box3+1);
				box2 = box3-1;
			}
			if(box1>=box2) {
				answer+=(box1-box2+1);
			}
			
			System.out.println("#"+test_case+" "+answer);
			
		}
	}
	
}

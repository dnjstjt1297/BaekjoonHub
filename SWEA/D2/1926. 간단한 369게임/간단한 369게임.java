import java.util.Scanner;
import java.io.FileInputStream;


class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=1;i<=N;i++) {
			int tmp =i;
			boolean is_369 = false;
			while(tmp>0) {
				int remainder = tmp%10;
				if(remainder == 3||remainder == 6||remainder == 9) {
					is_369 = true;
					System.out.print("-");
				}
				tmp = tmp/10;
			}
			if(!is_369) System.out.print(i+" ");
			else System.out.print(" ");
		}
	}
}
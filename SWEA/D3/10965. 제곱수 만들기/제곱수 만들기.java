import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		boolean[] is_primes = new boolean[10000001]; 
		is_primes[1] = true;
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2; i<=Math.sqrt(10000000)+1; i++) {
			if(is_primes[i]) continue;
			primes.add(i);
			for(int j= i*i; j<=10000000; j=j+i) {
				is_primes[j] = true;
			}
		}
		Collections.sort(primes);
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int answer =1;
			int tmp = N;
			for(int i=0; i<primes.size();i++) {
				int num = 0;
				while(true) {
					if(tmp%primes.get(i)==0) {
						tmp = tmp/primes.get(i);
						num++;
					}
					else break;
				}
				if(num%2 != 0) {
					answer*=primes.get(i);
				}
				if(!is_primes[tmp]) {
					answer*=tmp;
					break;
				}
			}
			
			System.out.println("#"+test_case+" "+answer);
		}
	}
	
}

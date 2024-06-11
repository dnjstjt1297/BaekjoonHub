import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=0;test_case<T;test_case++){
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			
			long p = R;
			long q = 1;
			st = new StringTokenizer(br.readLine());
			for(int i =0;i<N;i++){
				int K = Integer.parseInt(st.nextToken());
				p = p*(100-K);
				q = q*100;
				long g = gcd(p,q);
				if(g>0){
					p = p/g;
					q = q/g;	
				}
			}
			System.out.println(p+"/"+q);
		}
	}
	public static long gcd(long a, long b){
		while(b!=0){
			long tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
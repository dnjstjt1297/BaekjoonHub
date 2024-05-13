import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int M = 1000000007;
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			int X = Math.abs(sc.nextInt());
			int Y = Math.abs(sc.nextInt());
			
			int N = (X+Y)/3;
			if(N!=(double)(X+Y)/3) {
				System.out.println("#"+test_case+" 0");
				continue;
			}
			
			if(Math.min(X,Y)<N) {
				System.out.println("#"+test_case+" 0");
				continue;
			}
			int R = X-N;
			long answer = 0;
			
			answer = combLucas(N,R,M);
			System.out.println("#"+test_case+" "+answer);
			
		}
	}
	
	private static long combLucas(long n, long r, int M) {
		if(r == 0) {
            return 1;
        }
		long cn = 1;
        long A = 1;
        long B = 1;
        for(long i=1; i<=n; i++) {
            cn = (cn * i) % M;
            if(i == r) A = cn;
            if(i == n-r) B = cn;
        }
        return (((cn * pow(A, M-2,M)) % M) * pow(B, M-2,M)) % M;
    }
 
    private static long pow(long x, long pow, int M) {
    	long result = 1;
        x = x % M;
        if(pow == 0) {
            return 1;
        }
        while(pow > 0) {
            if(pow % 2 == 1) {
                result = (result*x) % M;
            }
            pow >>= 1;
            x = (x*x) % M;
        }
        return result;
    }
	
}
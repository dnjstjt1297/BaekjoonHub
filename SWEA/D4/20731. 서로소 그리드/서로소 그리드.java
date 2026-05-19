import java.util.*;
import java.io.*;



public class Solution {
    
	private static final int MAX_NUM = 50;
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();
        
        boolean[] primes = findPrimes(MAX_NUM);
        List<Integer>[] primeFactors = new List[MAX_NUM + 1];
        for (int i = 0; i <= MAX_NUM; i++) {
            primeFactors[i] = findPrimeFactors(primes, i);
        }
        
        for (int test_case = 1; test_case <= T; test_case++) {    
            int n = sc.nextInt();
            char[][] board = new char[n+1][n+1];
            
            for (int i = 1; i <= n; i++) {
                String input = sc.next();
                for (int j = 1; j <= n; j++) {
                    board[i][j] = input.charAt(j - 1);
                }
            }
            
            
            boolean[][] banned = new boolean[n+1][n + 1];
            boolean result = true;
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int diff = Math.abs(j - i);
                	if(diff==0)	continue;

                    List<Integer> factors = primeFactors[diff];
                    if (board[i][j] == '1') {
                    	if(i==j && i == 1) {
                    		continue;
                    	}
                    	
                        for (int p : factors) {
                            int bannedRemainder = (p - (i % p)) % p;
                            banned[p][bannedRemainder] = true;
                        }
                    }
                    else if (board[i][j] == '?') {
                        if (diff == 0) {
                            continue;
                        }
                        boolean canBeQuestion = false;
                        
                        for (int p : factors) {
                            int requiredRemainder = (p - (i % p)) % p;
                            if (!banned[p][requiredRemainder]) {
                                canBeQuestion = true;
                                break;
                            }
                        }
                        
                        if (!canBeQuestion) {
                            result = false;
                            break;
                        }
                    }
                    
                }
            }
            
            for (int p = 2; p <= n; p++) {
                if (!primes[p]) continue;
                
                boolean hasRemainder = false;
                for (int r = 0; r < p; r++) {
                    if (!banned[p][r]) {
                        hasRemainder = true;
                        break;
                    }
                }
                
                if (!hasRemainder) {
                    result = false;
                    break;
                }
            }
            
            
            
            
            
            if(result) {
            	System.out.println("#"+test_case+" YES");
            }
            else {
            	System.out.println("#"+test_case+" NO");
            }
        }
    }
    
    public static boolean[] findPrimes(int n) {
    	boolean[] primes = new boolean[n+1];
    	Arrays.fill(primes, true);
    	primes[0] = false;
    	primes[1] = false;
    	for(int i = 2; i<=n;i++) {
    		if(!primes[i]) continue;
    		for(int j = i*i; j<=n; j+=i) {
    			primes[j] = false;
    		}
    	}
    	return primes;
    }
    
    public static List<Integer> findPrimeFactors(boolean[] primes, int n){
    	List<Integer> factors = new ArrayList<>();
    	for(int i = 2; i <= n; i++) {
    		if(!primes[i]) continue;
    		if(n%i==0) factors.add(i);
    	}
    	return factors;
    }
    
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
}
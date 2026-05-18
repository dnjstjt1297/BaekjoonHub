import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int n = sc.nextInt(), m = sc.nextInt();
        	
        	BigInteger[] as = new BigInteger[n];
        	for(int i = 0; i<n;i++) as[i] = BigInteger.valueOf(sc.nextLong());
        	
        	BigInteger[] bs = new BigInteger[m];
        	for(int i = 0; i<m;i++) bs[i] =  BigInteger.valueOf(sc.nextLong());
        	
        	String result = "=";
        	for (int i = 0; i < n; i++) {
        	    BigInteger target = as[i];
        	    BigInteger currentLcm = BigInteger.ZERO;
        	    
        	    
        	    for (int j = 0; j < m; j++) {
        	        if (target.mod(bs[j]).equals(BigInteger.ZERO)) {
        	            if (currentLcm.equals(BigInteger.ZERO)) {
        	                currentLcm = bs[j];
        	            } else {
        	                currentLcm = getLcm(currentLcm, bs[j]);
        	            }
        	        }
        	    }
        	    
        	    
        	    if (!currentLcm.equals(target)) {
        	        result = "!";
        	        break;
        	    }
        	}
        	
        	
        	for (int i = 0; i < m; i++) {
        	    BigInteger target = bs[i];
        	    BigInteger currentLcm = BigInteger.ZERO;
        	    
        	    
        	    for (int j = 0; j < n; j++) {
        	        if (target.mod(as[j]).equals(BigInteger.ZERO)) {
        	            if (currentLcm.equals(BigInteger.ZERO)) {
        	                currentLcm = as[j];
        	            } else {
        	                currentLcm = getLcm(currentLcm, as[j]);
        	            }
        	        }
        	    }
        	    
        	    
        	    if (!currentLcm.equals(target)) {
        	        result = "!";
        	        break;
        	    }
        	}
        	System.out.println(result);
        }
    }
    
    private static BigInteger getGcd(BigInteger a, BigInteger b) {
    	BigInteger tmp;
    	while(b.compareTo(BigInteger.ZERO)>0) {
    		tmp = b;
    		b = a.mod(b);
    		a = tmp;
    	}
    	return a;
    }
    
    private static BigInteger getLcm(BigInteger a, BigInteger b) {
    	return (a.multiply(b)).divide(getGcd(a,b));
    }
}
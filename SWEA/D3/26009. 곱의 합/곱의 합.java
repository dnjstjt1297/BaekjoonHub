import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        BigInteger mod = new BigInteger("998244353");
        for (int test_case = 1; test_case <= T; test_case++) {    
        	String a = sc.next(), b = sc.next(), c = sc.next();
        	
        	BigInteger result;
        	
        	result = new BigInteger(a).multiply(new BigInteger(a).add(new BigInteger("1")));
        	result = result.multiply(new BigInteger(b).multiply(new BigInteger(b).add(new BigInteger("1"))));
        	result = result.multiply(new BigInteger(c).multiply(new BigInteger(c).add(new BigInteger("1"))));
        	
        	
        	result = result.divide(new BigInteger("8"));
        	result = result.mod(mod);
        	
    		System.out.println(result);
    		
        	
        }
    }
    
}
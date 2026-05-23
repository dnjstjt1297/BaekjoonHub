import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	String s = sc.next();
        	List<Integer> list = new ArrayList<>();
        	for(int i=s.length()-1; i>=0 ;i--) {
        		if(s.charAt(i)=='w') {
        			list.add(1);
        		}
        		else if(s.charAt(i)=='n') {
        			list.add(-1);
        		}
        	}
        	
        	int n = list.size();
        	long result = 0; 
        	if(list.get(0)==1) result += 90*Math.pow(2, n-1);
        	
        	for(int i = 1; i<n; i++) {
        		if(list.get(i)==-1) result -= Math.pow(2, n-1-i)*90;
        		else result += Math.pow(2, n-1-i)*90;
        	}
        	long g = gcd(result, (long) Math.pow(2, n-1));
        	StringBuilder sb = new StringBuilder();
        	sb.append(result/g);
        	if(Math.pow(2, n-1)/g!=1) {
        		sb.append("/");
        		sb.append((long) Math.pow(2, n-1)/g);
        	}
        	System.out.println("#"+ tc+" "+sb);
        	
        }
    }
    public static long gcd(long a, long b) {
    	while(b>0) {
    		long tmp = a;
    		a = b;
    		b = tmp%a;
    	}
    	return a;
    }
}
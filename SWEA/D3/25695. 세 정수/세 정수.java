import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int x = sc.nextInt(), y = sc.nextInt(), z = sc.nextInt();
        	
        	int a=-1,b=-1,c=-1;
        	if(x==y && x>=z) {
        		b = x;
        		c = z;
        		a = c;
        	}
        	else if(x==z && x>=y) {
        		a = x;
        		b = y;
        		c = b;
        	}else if(y==z && y>=x) {
        		c = y;
        		a = x;
        		b = a;
        	}
        	
        	System.out.println(a+" "+b+" "+c);
        	
    		
        	
        }
    }
    
}
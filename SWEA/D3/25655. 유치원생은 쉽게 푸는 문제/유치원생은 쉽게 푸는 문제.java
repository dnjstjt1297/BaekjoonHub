import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int x = sc.nextInt();
        	
        	StringBuilder n = new StringBuilder();
        	if(x == 1) {
        		n.append(0);
        	}
        	else if(x == 2) {
        		n.append(8);
        	}
        	else if(x%2==0) {
        		for(int i = 0; i<x/2; i++) {
        			n.append(8);
        		}
        	}
        	else if(x%2==1) {
        		n.append(4);
        		for(int i = 0; i<x/2; i++) {
        			n.append(8);
        		}
        	}
        	System.out.println(n.toString());
    		
        	
        }
    }
    
}
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	String s = sc.next();
        	int k = sc.nextInt();
        	
        	int idx = 0;
        	for(int i = 0; i<3;i++) {
    			if(s.charAt(i)=='o') {
    				idx = i;
    				break;
    			}
    		}
        	
        	int result = 0;
        	if(k==0) {
        		result = idx;
        	}
        	else {
        		if(idx==0 || idx==2) k--;
        		if(k%2==1) result = 0;
        		else result = 1;
        	}
        	System.out.println("#"+tc+" "+result);
        }
    }
}
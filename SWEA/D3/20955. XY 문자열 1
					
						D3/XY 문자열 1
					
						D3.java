import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	StringBuilder s = new StringBuilder(sc.next());
        	StringBuilder e = new StringBuilder(sc.next());
        	int n = s.length(), m = e.length();
        	
        	for(int i = m-1; i>=n; i--) {
        		if(e.charAt(i) == 'X') {
        			e.deleteCharAt(i);
        		}
        		else {
        			e.deleteCharAt(i);
        			e.reverse();
        		}
        	}
        	String result;
        	if(s.toString().equals(e.toString())) result = "Yes";
        	else result = "No";
        	System.out.println("#"+tc+" "+result);
        }
    }
}
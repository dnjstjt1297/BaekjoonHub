import java.util.*;
import java.io.*;

public class Solution {
	
    static final long MOD = 998244353;
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
            String input = sc.next();
            
            char[] s = new char[input.length()];
            for(int i = 0; i< s.length; i++) {
            	s[i] = input.charAt(i);
            }
            
            
            int l = 0;
            int r = s.length-1;
            int result = 0;
            while(r>l) {
            	if(s[l] == s[r]) {
            		l++; r--;
            		continue;
            	}
            	
            	if(s[l] != s[r]) {
            		
            		if(s[l] == 'x') {
            			l++;
            			result++;
            		}
            		else if(s[r] == 'x') {
            			r--;
            			result++;
            		}
            		else {
            			result = -1;
            			break;
            		}
            	}
            }
            System.out.println(result);
            

        }
    }
}
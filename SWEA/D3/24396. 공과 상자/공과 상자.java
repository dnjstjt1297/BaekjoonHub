import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int b = sc.nextInt(), w = sc.nextInt(), x = sc.nextInt(), y=sc.nextInt(), z = sc.nextInt();
        	
        	int result = b*x+w*y;
        	
        	if(x+y<2*z) {
        		if(w<b) {
        			result = result-w*(x+y)+2*w*z;
        		}
        		else {
        			result = result-b*(x+y)+2*b*z;
        		}
        	}
        	
        	
        	System.out.println(result);
        }
    }
}
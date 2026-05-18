import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int n = sc.nextInt(), m = sc.nextInt();
        	boolean[] as = new boolean[101];
        	boolean[] bs = new boolean[101];
        	for(int i = 0; i<n; i++) {
        		as[sc.nextInt()] = true;
        	}
        	
        	for(int i = 0; i<m; i++) {
        		bs[sc.nextInt()] = true;
        	}
        	
        	String result = "=";
        	for(int i = 0; i<101; i++) {
        		if(as[i] && !bs[i]) {
        			if(result.equals("=")) result = ">";
        			else if(result.equals("<")) {
        				result = "?";
        				break;
        			}
        		}
        		if(!as[i] && bs[i]) {
        			if(result.equals("=")) result = "<";
        			else if(result.equals(">")) {
        				result = "?";
        				break;
        			}
        		}
        	}
        	
        	System.out.println(result);
        }
    }
}
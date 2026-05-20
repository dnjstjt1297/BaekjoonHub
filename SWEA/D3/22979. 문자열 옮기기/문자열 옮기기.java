import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	String s = sc.next();
        	int n = sc.nextInt();
        	int sum = 0;
        	for(int i = 0; i<n; i++) {
        		sum = (sum+sc.nextInt())%s.length();
        	}
        	StringBuilder result = new StringBuilder();
        	result.append(s.substring(Math.floorMod(sum, s.length()),s.length()));
    		result.append(s.substring(0,Math.floorMod(sum, s.length())));
        	System.out.println(result);
        	
        }
    }
}
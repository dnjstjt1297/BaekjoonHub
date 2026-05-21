import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	int n = sc.nextInt();
        	StringBuilder sb = new StringBuilder();
        	if(n%3==1) {
        		sb.append("impossible");
        	}
        	else {
        		if(n%3==2) sb.append("BA");
        		for(int i =0; i<n/3; i++) {
        			sb.append("BBA");
        		}
        	}
        	System.out.println(sb);
        }
    }
}
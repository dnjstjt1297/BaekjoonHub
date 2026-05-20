import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	int max = 0, sum = 0;
        	for(int i = 0; i<6; i++) {
        		int len = sc.nextInt();
        		sum+=len;
        		max = Math.max(max, len);
        	}
        	for(int i = 1; i<=7; i++) {
        		if((sum+max+i)%7==0) {
        			System.out.println(max+i);
        			break;
        		}
        	}
        }
    }
}
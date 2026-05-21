import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	int n = sc.nextInt();
        	int p = sc.nextInt();
        	int sum = 0;
        	boolean visited = false;
        	for(int i = 0; i<=n;i++) {
        		sum += i;
        		
        		if(p==sum && !visited) {
        			sum -= 1;
        			visited = true;
        		}
        	}
        	System.out.println(sum);
        	
        }
    }
}
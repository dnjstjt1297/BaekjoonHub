import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	int n = sc.nextInt();
        	int[][] matrix = new int[n+1][n+1];
        	for(int i = 1; i<=n;i++) {
        		for(int j = 1; j<=n; j++) {
        			matrix[i][j] = sc.nextInt();
        		}
        	}
        	int result = 0;
        	int i = 2;
        	while(i<=n) {
        	    if(matrix[i][1]==i){
        	        result+=2;
        	        if (i==2) result--;
        	        while (i<=n && matrix[i][1]==i) {
        	            i++;
        	        }
        	    }
        	    else{
        	        i++;
        	    }
        	}
        	System.out.println(result);
        }
    }
}
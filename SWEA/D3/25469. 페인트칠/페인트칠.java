import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int h = sc.nextInt(), w = sc.nextInt();
        	char[][] board = new char[h][w];
        	
        	for(int i = 0; i<h;i++) {
        		String input = sc.next();
        		for(int j=0; j< input.length(); j++) {
            		board[i][j] = input.charAt(j);
        		}
        	}
    		
        	int rows = 0, cols = 0;
        	
        	for(int i = 0; i<h;i++) {
        		boolean isAllBlack = true;
        		for(int j = 0; j<w; j++) {
        			if(board[i][j] =='.') isAllBlack = false;
        		}
        		if(isAllBlack) rows++;
        	}
        	
        	for(int i = 0; i<w;i++) {
        		boolean isAllBlack = true;
        		for(int j = 0; j<h; j++) {
        			if(board[j][i] =='.') isAllBlack = false;
        		}
        		if(isAllBlack) cols++;
        	}
        	
        	int result = rows+cols;
        	if(rows+cols == h+w) {
        		result = Math.min(h, w);
        	}
        	System.out.println(result);
        	
        }
    }
    
}
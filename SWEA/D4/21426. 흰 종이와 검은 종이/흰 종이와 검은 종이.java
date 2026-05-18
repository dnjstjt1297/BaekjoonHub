import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
            int[] w1 = new int[4];
            int[] b1 = new int[4];
            int[] b2 = new int[4];
            
            for(int i = 0; i<4; i++) {
            	w1[i] = sc.nextInt();
            }
            for(int i = 0; i<4; i++) {
            	b1[i] = sc.nextInt();
            }
            for(int i = 0; i<4; i++) {
            	b2[i] = sc.nextInt();
            }
            
            if(findDuplicationArea(w1, b1)) {
            	System.out.println("NO");
            }
            else if(findDuplicationArea(w1, b2)) {
            	System.out.println("NO");
            }
            else {
            	System.out.println("YES");
            }
            
            
            
        }
    }
    
    public static boolean findDuplicationArea(int[] w, int[] b ) {
    	
    	
        if (b[0] <= w[0] && b[2] >= w[2] && b[1] <= w[1] && b[3] >= w[3]) {
            return true;
        }
    	
        if (b[1] <= w[1] && b[3] >= w[3]) {
            if (b[2] >= w[0] && b[2] <= w[2] && b[0] <= w[0]) {
                w[0] = b[2];
            }
            else if (b[0] >= w[0] && b[0] <= w[2] && b[2] >= w[2]) {
                w[2] = b[0];
            }
    	}
    	else if (b[0] <= w[0] && b[2] >= w[2]) {
            if (b[3] >= w[1] && b[3] <= w[3] && b[1] <= w[1]) {
                w[1] = b[3];
            }
            else if (b[1] >= w[1] && b[1] <= w[3] && b[3] >= w[3]) {
                w[3] = b[1];
            }
    	}
        if (w[0] >= w[2] || w[1] >= w[3]) return true;
        
        return false;
    }
}
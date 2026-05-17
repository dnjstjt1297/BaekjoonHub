import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int n = sc.nextInt();
        	int[] dots = new int[n];
        	for(int i = 0; i<n;i++) dots[i] = sc.nextInt();
        	
        	int[] oneJumpDist = new int[n-1];
        	int[] twoJumpDist = new int[n-2];
        	int sum = 0;
        	for(int i = 0; i<n-1; i++) {
        		oneJumpDist[i] = Math.abs(dots[i+1]-dots[i]);
        		sum+=oneJumpDist[i];
        	}
        	for(int i = 0; i<n-2; i++) twoJumpDist[i] = Math.abs(dots[i+2]-dots[i]);
        	
        	int result = sum;
        	for(int i=0; i<n-2; i++) {
        		result = Math.min(result, sum-oneJumpDist[i]-oneJumpDist[i+1]+twoJumpDist[i]);
        	}
        	System.out.println(result);
        	
        }
    }
}
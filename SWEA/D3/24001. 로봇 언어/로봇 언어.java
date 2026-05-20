import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	String s = sc.next();
        	int[] nums = new int[s.length()];
        	for(int i = 0; i<s.length(); i++) {
        		if(s.charAt(i)=='L') nums[i] = -1;
        		else if(s.charAt(i)=='R') nums[i] = 1;
        		else nums[i] = 0;
        	}
        	
        	int max = 0;
        	int sum = 0, count=0;
        	for(int i = 0; i<nums.length;i++) {
        		sum+=nums[i];
        		if(nums[i]==0) count++;
        		max = Math.max(max, Math.abs(sum)+count);
        	}
        	System.out.println(max);
            
        }
    }
}
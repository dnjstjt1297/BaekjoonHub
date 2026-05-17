import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	String input = sc.next();
        	int[] s = new int[input.length()];
        	for(int i = 0; i<s.length;i++) {
        		s[i] = input.charAt(i)-'0';
        	}
        	
        	boolean[] numVisited = new boolean[10];
        	boolean[] visited = new boolean[s.length];
        	
        	boolean result = true;
        	for(int i = 0; i<s.length; i++) {
        		if(visited[i]) continue;
        		if(numVisited[s[i]]) {
        			result = false;
        			break;
        		}
        		visited[i] = true;
        		
        		if(i<=s.length-s[i]-2 && s[i] == s[i+s[i]+1]) {
        			visited[i+s[i]+1] = true;
        			numVisited[s[i]] = true;
        		}
        		else{
        			result = false;
        			break;
        		}
        	}
        	if(result) System.out.println("yes");
        	else System.out.println("no");
        }
    }
    
}
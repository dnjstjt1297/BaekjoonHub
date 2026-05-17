import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	String a = br.readLine();
        	
        	boolean[] visited = new boolean['Z'];
        	
        	for(int i = 0; i<a.length(); i++) {
        		visited[a.charAt(i)] = true;
        	}
        	
        	String result = "No";
        	if(visited['N'] && visited['S'] && !visited['W'] && !visited['E']) {
        		result = "Yes";
        	}
        	else if(!visited['N'] && !visited['S'] && visited['W'] && visited['E']){
        		result = "Yes";
        	}
        	else if(visited['N'] && visited['S'] && visited['W'] && visited['E']) {
        		result = "Yes";
        	}
        	System.out.println(result);
        	
        }
    }
    
}
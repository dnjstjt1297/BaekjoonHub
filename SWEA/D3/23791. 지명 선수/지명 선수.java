import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {    
        	int n = sc.nextInt();
        	int[] as = new int[n];
        	int[] bs = new int[n];
        	for(int i = 0; i<n;i++) as[i] = sc.nextInt();
            for(int i = 0; i<n;i++) bs[i] = sc.nextInt();
            
            char[] seqs = new char[n+1];
            boolean[] visited = new boolean[n+1];
            int l=0, r=0;
            while(l<n && r<n) {
            	while(l<n) {
        			if(visited[as[l]]) {
        				l++;
        				continue;
        			}
            		visited[as[l]] = true;        		
        			seqs[as[l++]] = 'A';
        			break;
	            }
        		while(r<n) {
        			if(visited[bs[r]]) {
        				r++;
        				continue;
        			}
	        		visited[bs[r]] = true;
	        		seqs[bs[r++]] = 'B';
	        		break;
        		}
            }
            
            for(int i = 1; i<=n; i++) System.out.print(seqs[i]);
            System.out.println();
        }
    }
}
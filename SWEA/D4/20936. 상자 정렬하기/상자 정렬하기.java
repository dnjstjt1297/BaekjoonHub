import java.util.*;
import java.io.*;

public class Solution {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
            int n = sc.nextInt();
            int[] as = new int[n+2];
            as[0] = -1;
            as[n+1] = 0;
            for(int i = 1; i<=n; i++) {
            	as[i] = sc.nextInt();
            }
            
            
            List<Integer> seqs = new ArrayList<>();
            int zeroIdx = n+1;
            
        
            roop: while(true) {
            	if(zeroIdx==n+1) {
            		for(int i = 1; i<=n;i++) {
	                	if(as[i] == i) continue;
	                	change(as, i, zeroIdx);
	                	zeroIdx = i;
	                	seqs.add(i);
	                	continue roop;
	                }
            		break;
            	}
            	else {
	            	for(int i = 1; i<=n+1;i++) {
	            		if(zeroIdx==as[i]) {
	            			change(as, i, zeroIdx);
	            			zeroIdx = i;
		                	seqs.add(i);
	                    	break;
	            		}
	            	}
            	}
            	
            }
            
            System.out.println(seqs.size());
            StringBuilder sb = new StringBuilder();
            for(int e: seqs) {
            	sb.append(e+" ");
            }
            System.out.println(sb.toString().trim());
            
            
        }
    }
    
    public static void change(int[] arr, int a, int b) {
    	int tmp = arr[a];
    	arr[a] = arr[b];
    	arr[b] = tmp;
    }
    
}
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int n = sc.nextInt();
        	long x = Math.abs(sc.nextInt());
        	
        	
        	int[] ds = new int[n];
        	long cycleSum = 0;
        	for(int i = 0; i<n; i++) {
        		ds[i] = sc.nextInt();
        		cycleSum+=ds[i];
        	}
        	
        	if(x==0) {
        		System.out.println(0);
        		continue;
        	}
        	
        	long result = 0;
        	long sum = 0;
        	long max = 0;
        	
        	if(x>2*cycleSum) {
        		long cycles = (x-2*cycleSum)/cycleSum;
        		if(cycles>0) {
        			result+=cycles*n;
        			sum += cycles*cycleSum;
        			max = cycleSum;
        			
        		}
        	}
        	int idx = (int) (result%n);
        	while (true) {
                long nextD = ds[idx];
                sum += nextD;
                if (nextD >max) {
                    max = nextD;
                }
                result++;
                
                long restPlusX = (sum - max) + x;
                
                if (sum >= x && max <= restPlusX) {
                    break;
                }
                
                idx = (idx + 1) % n;
            }
        	
        	
        	
        	System.out.println(result);        	
        }
    }
}
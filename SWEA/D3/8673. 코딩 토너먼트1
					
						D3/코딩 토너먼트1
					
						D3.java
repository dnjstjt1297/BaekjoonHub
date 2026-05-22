import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	int k = sc.nextInt();
        	
        	List<Integer> as = new ArrayList<>();
        	
        	for(int i =0; i<Math.pow(2, k);i++) {
        		as.add(sc.nextInt());
        	}
        	
        	List<Integer> tmp = new ArrayList<>();
        	int result = 0;
        	while(as.size()>1) {
        		for(int i = 0; i<as.size(); i+=2) {
        			tmp.add(Math.max(as.get(i), as.get(i+1)));
        			result+=Math.abs(as.get(i)-as.get(i+1));
        		}
        		as = tmp;
        		tmp = new ArrayList<>();
        	}
        	System.out.println("#"+tc+" "+result);
        }
    }
}
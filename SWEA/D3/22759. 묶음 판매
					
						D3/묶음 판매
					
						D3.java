import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {    
        	int l = sc.nextInt(), r = sc.nextInt();
        	if(r+1<=2*l) System.out.println("yes");
        	else System.out.println("no");
        	
        }
    }
}
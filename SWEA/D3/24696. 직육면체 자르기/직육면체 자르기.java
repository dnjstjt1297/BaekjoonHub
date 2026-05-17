import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
        	int a=sc.nextInt(),b=sc.nextInt(),c=sc.nextInt();
        	int result;
        	if((a*b*c-1)%2==0) result = 2;
        	else result = 1;
    		System.out.println(result);
        }
    }
}
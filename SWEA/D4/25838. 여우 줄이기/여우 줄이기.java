import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine().trim());
            String word = br.readLine().trim();
            StringBuilder stack = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                stack.append(word.charAt(i));
                int len = stack.length();
                if (len >= 3) {
                    if (stack.charAt(len - 3) == 'f' && 
                        stack.charAt(len - 2) == 'o' && 
                        stack.charAt(len - 1) == 'x') {
                        stack.delete(len - 3, len);
                    }
                }
            }
            System.out.println(stack.length());
        }
    }
}
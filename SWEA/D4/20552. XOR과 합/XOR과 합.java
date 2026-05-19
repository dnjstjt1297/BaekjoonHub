import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
            long x = sc.nextLong();
            long s = sc.nextLong();
            
            int num = 0;
            List<Long> list = new ArrayList<>();
            
            if(s < x || (s - x) % 2 == 1) {
                num = -1;
            }
            else if(s == x) {
                if(x == 0) {
                    num = 0;
                } else {
                    num = 1;
                    list.add(x);
                }
            }
            else {
                long a = (s - x) / 2;
                if (((a + x) ^ a) == x) { 
                    num = 2;
                    list.add(a + x);
                    list.add(a);
                } 
                else {
                    num = 3;
                    list.add(a);
                    list.add(a);
                    list.add(x);
                }
            }
            
            System.out.println(num);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
            if(num >= 1) System.out.println(sb.toString().trim());
        }
    } 
}
import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {    
            long sVal = sc.nextLong();
            long pVal = sc.nextLong();
            
            BigInteger s = BigInteger.valueOf(sVal);
            BigInteger p = BigInteger.valueOf(pVal);
            
            BigInteger sSquare = s.multiply(s);
            BigInteger fourP = p.multiply(BigInteger.valueOf(4));
            BigInteger d = sSquare.subtract(fourP);
            
            if (d.compareTo(BigInteger.ZERO) < 0) {
                System.out.println("No");
                continue;
            }
            
            BigInteger e = sqrt(d);
            
            if (!e.multiply(e).equals(d)) {
                System.out.println("No");
                continue;
            }
            
            long r1 = sVal + e.longValue();
            long r2 = sVal - e.longValue();
            
            if (r1 % 2 == 0 && r2 % 2 == 0) {
                if (r1 > 0 && r2 > 0) {
                    System.out.println("Yes");
                    continue;
                }
            }
            System.out.println("No");
        }
        sc.close();
    }
    
    public static BigInteger sqrt(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return n;
        }
        
        BigInteger start = BigInteger.ONE;
        BigInteger end = n;
        BigInteger ans = BigInteger.ZERO;
        
        while (start.compareTo(end) <= 0) {
            BigInteger mid = start.add(end).divide(BigInteger.valueOf(2));
            BigInteger midSquare = mid.multiply(mid);
            
            int cmp = midSquare.compareTo(n);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                ans = mid;
                start = mid.add(BigInteger.ONE);
            } else {
                end = mid.subtract(BigInteger.ONE);
            }
        }
        return ans;
    }
}
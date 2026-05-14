import java.util.*;
import java.io.*;
public class Solution {
	public static void main (String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int k = Math.abs(sc.nextInt());
			long result = 0;
			for(int ab=k+2; ab<=2*n;ab++) {
				int cd = ab-k;
				long abCnt = Math.min(ab - 1, 2 * n - ab + 1);
			    long cdCnt = Math.min(cd - 1, 2 * n - cd + 1);
			    result += abCnt * cdCnt;
			}
			System.out.println(result);
		}
	}
}
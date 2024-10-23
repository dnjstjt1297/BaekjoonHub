import java.util.*;
import java.io.*;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long result = dq(A,B,C);
		
		
		System.out.println(result);
	
	}
	
	public static long dq(int A, int B, int C) {
		if(B==1) return A%C;
		long tmp = dq(A, B/2,C);
		
		if(B%2==1) return (((tmp*tmp)%C)*A)%C;
		else return (tmp*tmp)%C;
	}
}

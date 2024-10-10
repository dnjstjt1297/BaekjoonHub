import java.util.*;
import java.io.*;


public class Main {
	static int INF = 10001;
	
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		int[] g = new int[INF];
		int[] f = new int[INF];
		
		g[1] = 1;
		g[2] = 2;
		g[3] = 2;
		
		f[1] = 1;
		f[2] = 2;
		f[3] = 3;
		
		
		for(int i = 4; i<INF;i++) g[i] = g[i-2]+1;
		for(int i = 4; i<INF;i++) f[i] = f[i-3]+g[i-2]+1;
		
		
		for(int i = 0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(f[n]);
		}
	} 
	
}
